package app.com.bugdroidbuilder.paulo.droidhealth.view;

import android.app.Activity;
import android.widget.EditText;

import app.com.bugdroidbuilder.paulo.droidhealth.R;

/**
 * Created by paulo on 09/04/16.
 */
public class Leitor {
    private Activity activity;



    public Leitor(Activity activity) {
        this.activity = activity;
    }
    public void updateActivity(Activity activity) {
        this.activity = activity;
    }

    //Estrutura para verificar de qual fragment é o peso a ser lido
    public final float lerPeso(String tipo){
        EditText peso;
        switch(tipo){
            case "imc":
                peso = (EditText) activity.findViewById(R.id.imc_peso);
                break;
            case "imb":
                peso = (EditText) activity.findViewById(R.id.imb_peso);
                break;
            case "hdr":
                peso = (EditText) activity.findViewById(R.id.hdr_peso);
                break;
            default:
                peso = (EditText) activity.findViewById(R.id.imc_peso);
        }
        //converte altura para float e retorna
        return Float.parseFloat(peso.getText().toString());

    }


    //Estrutura para verificar de qual fragment é a altura a ser lida
    public final float lerAltura(String tipo){
        EditText altura ;
        switch(tipo){
            case "imc":
                altura = (EditText) activity.findViewById(R.id.imc_altura);
                break;
            case "imb":
                altura = (EditText) activity.findViewById(R.id.imb_altura);
                break;
            default:
                altura = (EditText) activity.findViewById(R.id.imc_altura);
        }
        //converte altura para float e retorna
        return Float.parseFloat(altura.getText().toString());

    }
    //lerSexo(){}
    //lerQntExFisico(){}
}
