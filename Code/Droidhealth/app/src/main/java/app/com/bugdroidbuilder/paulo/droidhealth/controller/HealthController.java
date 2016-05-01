package app.com.bugdroidbuilder.paulo.droidhealth.controller;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Person;

public class HealthController {

    private CalcHealth calculator;

    private boolean hasButton = true;

    private static boolean weightExists = false ;
    private static boolean heightExists = false;
    private static boolean ageExists = false;

    public HealthController(){
        this.calculator = new CalcHealth();

    }


    /** Show review about the user, weight, ideal weight, height, health condition(based on BMI)...
     *
     * @param mainActivity Activity needed to access layouts
     */
    public void showReview(Activity mainActivity){
        Button btConfig = (Button) mainActivity.findViewById(R.id.bt_go_settings);
        if(weightExists){
            showHDR(mainActivity);
            if(heightExists){

                if(hasButton){
                    ViewGroup layout = (ViewGroup) btConfig.getParent();
                    layout.removeView(btConfig);
                    hasButton = false;
                }

                showBMI(mainActivity);
                if(ageExists){
                      showBMR(mainActivity);
                }
            }
        }
    }

    /** Show to user hydration on the screen
     *
     * @param mainActivity activity necessary to take a reference to app layout
     */
    public void showHDR(Activity mainActivity){
        TextView heightView = (TextView) mainActivity.findViewById(R.id.height_text_view);
        heightView.setText(mainActivity.getResources().getString(R.string.better_information));
        TextView hdrView = (TextView) mainActivity.findViewById(R.id.hdr_text_view);
        TextView imcView = (TextView) mainActivity.findViewById(R.id.bmi_text_view);
        showWeight(mainActivity);
        imcView.setText("");
        this.calculator.calcHDR();
        hdrView.setText(Person.getStringHDR());

    }

    /** Show to user body mass index on the screen
     *
     * @param mainActivity activity necessary to take a reference to app layout
     */
    public void showBMI(Activity mainActivity){
        showHeight(mainActivity);
        showWeight(mainActivity);
        TextView imcView = (TextView) mainActivity.findViewById(R.id.bmi_text_view);
        this.calculator.calcBMI();
        imcView.setText(Person.getStringBMI());
        imcView.setTextSize(48);
    }

    /** Show to user height on the screen
     *
     * @param mainActivity activity necessary to take a reference to app layout
     */
    private void showHeight(Activity mainActivity){
        TextView alturaView = (TextView) mainActivity.findViewById(R.id.height_text_view);
        alturaView.setText(Person.getStringHeight());
    }

    /** Show to user weight on the screen
     *
     * @param mainActivity activity necessary to take a reference to app layout
     */
    private void showWeight(Activity mainActivity){
        TextView pesoView = (TextView) mainActivity.findViewById(R.id.weight_text_view);
        pesoView.setText(Person.getStringWeight());
    }

    /** Show to user basal metabolic rate on the screen
     *
     * @param mainActivity activity necessary to take a reference to app layout
     */
    public void showBMR(Activity mainActivity){
        TextView imbView = (TextView) mainActivity.findViewById(R.id.calories_per_day);
        this.calculator.calcBMR();
        imbView.setText(Person.getStringBMR());

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

    public static boolean pesoExists() {
        return weightExists;
    }

    public static void setWeightExists(boolean weightExists) {
        HealthController.weightExists = weightExists;
    }

}
