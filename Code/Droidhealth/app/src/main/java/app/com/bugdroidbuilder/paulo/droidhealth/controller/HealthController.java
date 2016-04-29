package app.com.bugdroidbuilder.paulo.droidhealth.controller;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Pessoa;

public class HealthController {
    private Activity perfilActivity;


    private CalcHealth calculator;

    private final int MAX_PESO = 400;
    private final int MAX_ALTURA = 260;
    private final int MIN_PESO = 30;
    private boolean hasButton = true;
    private final int MIN_ALTURA = 100;
    private final int MAX_IDADE = 120;
    private final int MIN_IDADE = 5;
    private static boolean pesoExists = false;
    private static boolean alturaExists = false;
    private static boolean idadeExists = false;

    public HealthController(Activity _activity){
        this.perfilActivity = _activity;
        this.calculator = new CalcHealth();
    }



    public void mostrarResumo(){
        Button btConfig = (Button) perfilActivity.findViewById(R.id.bt_ir_config);
        if(pesoExists){
            mostrarHDR();
            if(alturaExists){

                if(hasButton){
                    ViewGroup layout = (ViewGroup) btConfig.getParent();
                    layout.removeView(btConfig);
                    hasButton = false;
                }

                mostrarIMC();
                if(idadeExists){
                      mostrarIMB();
                }
            }
        }
    }


    public void mostrarHDR(){
        mostrarPeso();
        TextView hdrView = (TextView) perfilActivity.findViewById(R.id.qnt_agua_text_view);
        TextView imcView = (TextView) perfilActivity.findViewById(R.id.imc_text_view);
        mostrarPeso();
        imcView.setText("");
        String hdrString = this.calculator.calcAgua();
        hdrView.setText(hdrString);

    }
    public void mostrarIMC(){
        mostrarAltura();
        TextView imcView = (TextView) perfilActivity.findViewById(R.id.imc_text_view);
        this.calculator.calcIMC();
        imcView.setText(Pessoa.getImcString());
        imcView.setTextSize(48);
    }
    private void mostrarAltura(){
        TextView alturaView = (TextView) perfilActivity.findViewById(R.id.altura_text_view);
        alturaView.setText(Pessoa.getAlturaString());
    }
    private void mostrarPeso(){
        TextView pesoView = (TextView) perfilActivity.findViewById(R.id.peso_text_view);
        pesoView.setText(Pessoa.getPesoString());
    }
    public void mostrarIMB(){
        TextView imbView = (TextView) perfilActivity.findViewById(R.id.qnt_calorias_text_view);
        String imbString = this.calculator.calcIMB();
        imbView.setText(imbString);

    }
    public static boolean idadeExists() {
        return idadeExists;
    }

    public static void setIdadeExists(boolean idadeSetExists) {
        HealthController.idadeExists = idadeSetExists;
    }

    public static boolean alturaExists() {
        return alturaExists;
    }

    public static void setAlturaExists(boolean alturaExists) {
        HealthController.alturaExists = alturaExists;
    }

    public static boolean pesoExists() {
        return pesoExists;
    }

    public static void setPesoExists(boolean pesoExists) {
        HealthController.pesoExists = pesoExists;
    }

    public int getMIN_ALTURA() {
        return MIN_ALTURA;
    }

    public int getMIN_PESO() {
        return MIN_PESO;
    }

    public int getMAX_ALTURA() {
        return MAX_ALTURA;
    }

    public int getMAX_PESO() {
        return MAX_PESO;
    }

    public int getMAX_IDADE() {
        return MAX_IDADE;
    }

    public int getMIN_IDADE() {
        return MIN_IDADE;
    }
}
