package app.com.bugdroidbuilder.paulo.droidhealth.controller;

import android.app.Activity;
import android.widget.TextView;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Pessoa;
import app.com.bugdroidbuilder.paulo.droidhealth.view.Leitor;

public class HealthController {
    private Activity activity;

    private Pessoa usuario;

    private Leitor leitor;
    private CalcHealth calculator;

    private final int MAX_PESO = 400;
    private final int MAX_ALTURA = 260;
    private final int MIN_PESO = 30;
    private final int MIN_ALTURA = 100;
    private final int MAX_IDADE = 120;
    private final int MIN_IDADE = 5;

    public HealthController(Activity _activity){
        this.activity = _activity;
        this.usuario = new Pessoa();
        this.leitor = new Leitor(_activity);
        this.calculator = new CalcHealth(usuario);

    }

    public void updateActivity(Activity _activity){
        this.activity = _activity;
        this.leitor.updateActivity(_activity);
    }


    public void mostrarHDR(){
        TextView hdrView = (TextView)this.activity.findViewById(R.id.hdr_view);
        String hdrString = this.calculator.calcAgua(this.leitor.lerPeso());
        hdrView.setText(hdrString);
    }
    public void mostrarIMC(){
        TextView imcView = (TextView)this.activity.findViewById(R.id.imc_view);
        String imcString = this.calculator.calcIMC(this.leitor.lerPeso(), this.leitor.lerAltura());
        imcView.setText(imcString);
    }
    public void mostrarIMB(){
        TextView imbView = (TextView) this.activity.findViewById(R.id.imb_view);
        String imbString = this.calculator.calcIMB(this.leitor.lerPeso(), this.leitor.lerAltura(),
                this.leitor.lerIdade() , this.leitor.lerSpinner("sexo"),
                this.leitor.lerSpinner("exercicios"));
        imbView.setText(imbString);

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
