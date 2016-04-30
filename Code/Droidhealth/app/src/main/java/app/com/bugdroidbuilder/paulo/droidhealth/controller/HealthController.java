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

    private static boolean weightExists = false;
    private static boolean heightExists = false;
    private static boolean ageExists = false;

    public HealthController(Activity _activity){
        this.calculator = new CalcHealth();
    }



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


    public void showHDR(Activity mainActivity){
        showWeight(mainActivity);
        TextView hdrView = (TextView) mainActivity.findViewById(R.id.qnt_agua_text_view);
        TextView imcView = (TextView) mainActivity.findViewById(R.id.imc_text_view);
        showWeight(mainActivity);
        imcView.setText("");
        String hdrString = this.calculator.calcWaterQnt();
        hdrView.setText(hdrString);

    }
    public void showBMI(Activity mainActivity){
        showHeight(mainActivity);
        TextView imcView = (TextView) mainActivity.findViewById(R.id.imc_text_view);
        this.calculator.calcBMI();
        imcView.setText(Person.getStringBMI());
        imcView.setTextSize(48);
    }
    private void showHeight(Activity mainActivity){
        TextView alturaView = (TextView) mainActivity.findViewById(R.id.altura_text_view);
        alturaView.setText(Person.getStringHeight());
    }
    private void showWeight(Activity mainActivity){
        TextView pesoView = (TextView) mainActivity.findViewById(R.id.peso_text_view);
        pesoView.setText(Person.getStringWeight());
    }
    public void showBMR(Activity mainActivity){
        TextView imbView = (TextView) mainActivity.findViewById(R.id.qnt_calorias_text_view);
        String imbString = this.calculator.calcBMR();
        imbView.setText(imbString);

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
