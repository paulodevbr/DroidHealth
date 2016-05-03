package app.com.bugdroidbuilder.paulo.droidhealth.controller;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Person;
import app.com.bugdroidbuilder.paulo.droidhealth.view.MainActivity;

public class HealthController {

    private CalcHealth calculator;

    private boolean hasButton = true;

    private static boolean weightExists = false;
    private static boolean heightExists = false;
    private static boolean ageExists = false;

    public HealthController(){
        this.calculator = new CalcHealth();
    }



    public void showReview(Activity mainActivity){
       Button btSettings = (Button) mainActivity.findViewById(R.id.bt_go_settings);

        if(weightExists ){
            showHDR(mainActivity);
            if(heightExists){

                if(hasButton){
                    ViewGroup layout = (ViewGroup) btSettings.getParent();
                    layout.removeView(btSettings);
                    hasButton = false;
                }

                showBMI(mainActivity);
                if(ageExists){
                      showBMR(mainActivity);
                }
            }
        }
    }


    public void showHDR(Activity mainActivity){
        TextView hdrView = (TextView) mainActivity.findViewById(R.id.qnt_agua_text_view);
        TextView bmiView = (TextView) mainActivity.findViewById(R.id.imc_text_view);
        showWeight(mainActivity);
        bmiView.setText("");
        this.calculator.calcHDR();
        String hdrString = Person.getStringHDR();
        hdrView.setText(hdrString);

    }
    public void showBMI(Activity mainActivity){
        showHeight(mainActivity);
        TextView bmiView = (TextView) mainActivity.findViewById(R.id.imc_text_view);
        this.calculator.calcBMI();
        bmiView.setText(Person.getStringBMI());
        bmiView.setTextSize(48);
    }
    private void showHeight(Activity mainActivity){
        TextView heightView = (TextView) mainActivity.findViewById(R.id.altura_text_view);
        heightView.setText(Person.getStringHeight());
    }
    private void showWeight(Activity mainActivity){
        TextView weightView = (TextView) mainActivity.findViewById(R.id.peso_text_view);
        weightView.setText(Person.getStringWeight());
    }
    public void showBMR(Activity mainActivity){
        TextView bmrView = (TextView) mainActivity.findViewById(R.id.qnt_calorias_text_view);
        String bmrString = this.calculator.calcBMR();
        bmrView.setText(bmrString);

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

}
