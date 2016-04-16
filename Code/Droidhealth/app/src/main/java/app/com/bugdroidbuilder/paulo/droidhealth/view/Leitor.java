package app.com.bugdroidbuilder.paulo.droidhealth.view;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;

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
    public int lerPeso(){
        EditText peso;

        peso = (EditText) activity.findViewById(R.id.config_peso);

        //converte altura para float e retorna
        return Integer.parseInt(peso.getText().toString());

    }


    //Estrutura para verificar de qual fragment é a altura a ser lida
    public int lerAltura(){
        EditText altura ;
        altura = (EditText) activity.findViewById(R.id.imc_altura);
        //converte altura para float e retorna
        return Integer.parseInt(altura.getText().toString());

    }

    // Procura a view EditText, requisita o texto inserido pelo usuário,
    // transforma para int e retorna a idade
    public int lerIdade(){
        EditText idade;
        idade = (EditText) activity.findViewById(R.id.config_idade);
        return Integer.parseInt(idade.getText().toString());

    }


    // Lê qualquer Spinner do programa de acordo com o parâmetro passado
    public String lerSpinner(String tipo){
        Spinner spinner;

        switch(tipo){
            case"sexo":
                spinner = (Spinner) activity.findViewById(R.id.imb_sexo_spinner);
                break;
            case "exercicios":
                spinner = (Spinner) activity.findViewById(R.id.config_exercicios_spinner);
                break;
            default:
                spinner = (Spinner) activity.findViewById(R.id.config_sexo_spinner);
        }
        return spinner.getSelectedItem().toString();
     }

}
