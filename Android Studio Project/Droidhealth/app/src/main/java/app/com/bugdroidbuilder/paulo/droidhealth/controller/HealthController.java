package app.com.bugdroidbuilder.paulo.droidhealth.controller;

import android.app.Activity;
import android.widget.FrameLayout;
import android.widget.TextView;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Person;

public class HealthController {

    private CalcHealth calculator;
    private static boolean weightExists = false;
    private static boolean heightExists = false;
    private static boolean ageExists = false;

    private static boolean higherWeight;
    private static boolean lowerWeight;
    private Activity mainActivity;
    private static int color = 0;

    public HealthController(){
        this.calculator = new CalcHealth();
    }

    public void showReview(Activity mainActivity){
        this.mainActivity = mainActivity;
        // if the user has inserted weight, it s possible to calculate the hydration
        if(weightExists ){
            showHDR();
            //if the user has inserted height and weight, it's possible to calculate the Body Mass Index
            if(heightExists){

                showBMI();

                //if the user has inserted the data before + age, it's also possible to calculate the Basal Metabolic Rate
                if(ageExists){
                      showBMR();
                }
            }
        }
    }


    /**
     * Calculate and show on the screen user hydration per day
     */
    private void showHDR(){
        TextView hdrView = (TextView) mainActivity.findViewById(R.id.qnt_water_text_view);
        TextView bmiView = (TextView) mainActivity.findViewById(R.id.bmi_text_view);
        TextView heightView = (TextView) mainActivity.findViewById(R.id.height_text_view);

        //Show the weight just if the color wasnt set. If was, the method showBMI will call showWeight() itself
        if(getColorHealthState() == 0){
            showWeight();

            //Set the bigger Text of feedback to hydration
            bmiView.setText(mainActivity.getResources().getString(R.string.hydration));

            heightView.setText("");
        }

        this.calculator.calcHDR(Person.getWeight());
        String hdrString = Person.getStringHDR();
        hdrView.setText(hdrString);

    }

    /**
     * Calculate and show on the screen the Body Mass Index
     */
    private void showBMI(){
        TextView bmiView = (TextView) mainActivity.findViewById(R.id.bmi_text_view);
        this.calculator.calcBMI(Person.getWeight(), Person.getHeight());
        showHeight();
        showIdealWeight();
        showWeight();
        //Show the health condition
        bmiView.setText(Person.getStringBMI());
        bmiView.setTextSize(33);


        FrameLayout line1 = (FrameLayout) mainActivity.findViewById(R.id.bmi_line);
        //Set the line color under the health condition
        line1.setBackgroundColor(mainActivity.getResources().getColor(getColorHealthState()));
        //Set the health condition text color
        bmiView.setTextColor(mainActivity.getResources().getColor(getColorHealthState()));
    }

    /**
     * Calculate and show on the screen the Basal Metabolic Rate
     */
    private void showBMR(){
        TextView bmrView = (TextView) mainActivity.findViewById(R.id.qnt_calories_text_view);
        String bmrString = this.calculator.calcBMR(Person.getWeight(), Person.getHeight(), Person.getAge());
        bmrView.setText(bmrString);
        showWeightAdvice();

    }

    private void showHeight(){
        TextView heightView = (TextView) mainActivity.findViewById(R.id.height_text_view);
        heightView.setText(Person.getStringHeight());
    }

    private void showWeight(){
        TextView weightView = (TextView) mainActivity.findViewById(R.id.weight_text_view);
        weightView.setText(Person.getStringWeight());



        if(isHigherWeight()||isLowerWeight()){
            //Check if health color was already set, avoiding nullPointerException
            if(getColorHealthState() != 0){
                weightView.setTextColor(mainActivity.getResources().getColor(getColorHealthState()));
            }
        }else{
            weightView.setTextColor(mainActivity.getResources().getColor(R.color.colorTextTabUnselected));
        }

    }

    private void showIdealWeight(){
        TextView weightView = (TextView) mainActivity.findViewById(R.id.ideal_weight_text_view);
        //If the user is above or bellow its healthy weight, show a recommendation
        if(isHigherWeight()||isLowerWeight()){
            weightView.setText(Person.getStringIdealWeight());
        }
        //if not, do not show anything and erase the content on that TextView
        else{
            weightView.setText("");
        }

    }

    private void showWeightAdvice(){
        TextView adviceView = (TextView) mainActivity.findViewById(R.id.weight_advice_text_view);
        FrameLayout line = (FrameLayout) mainActivity.findViewById(R.id.advice_line);
        line.setBackgroundColor(mainActivity.getResources().getColor(getColorHealthState()));

        //If the user is above or bellow its healthy weight, show a recommendation
        if(isHigherWeight()||isLowerWeight()){
            adviceView.setTextSize(18);
            adviceView.setText(Person.getStringAdviceWeight());
        }
        //if not, do not show anything and erase the content on that TextView
        else{
            adviceView.setText(Person.getStringAdviceWeight());
            adviceView.setTextSize(24);
            adviceView.setTextColor(mainActivity.getResources().getColor(getColorHealthState()));
        }
    }

    public static boolean ageExists() {
        return ageExists;
    }

    public static void setAgeExists(boolean idadeSetExists) {
        HealthController.ageExists = idadeSetExists;
    }

    public static boolean heightExists() {
        return heightExists;
    }

    public static void setHeightExists(boolean heightExists) {
        HealthController.heightExists = heightExists;
    }

    public static boolean weightExists() {
        return weightExists;
    }

    public static void setWeightExists(boolean weightExists) {
        HealthController.weightExists = weightExists;
    }

    public static int getColorHealthState() {
        return color;
    }

    public static void setColor(int color) {
        HealthController.color = color;
    }

    public static boolean isHigherWeight() {
        return higherWeight;
    }

    public static void setHigherWeight(boolean higherWeight) {
        HealthController.higherWeight = higherWeight;
    }

    public static boolean isLowerWeight() {
        return lowerWeight;
    }

    public static void setLowerWeight(boolean lowerWeight) {
        HealthController.lowerWeight = lowerWeight;
    }
}
