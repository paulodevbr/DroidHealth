package app.com.bugdroidbuilder.paulo.droidhealth.view.calculator;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;


public class CalcAlimentacaoFragment extends Fragment {

    private boolean pesoValido = false;
    private boolean alturaValida = false;
    private boolean idadeValida = false;
    private HealthController healthController = new HealthController(getActivity());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alimentacao, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        TextInputEditText edtPeso = (TextInputEditText) getActivity().findViewById(R.id.imb_peso);
        //Listener que verifica quando o campo peso é alterado
        edtPeso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                /* verifica se o peso é menor que o peso máximo e menor que o peso mínimo
                 * e se o usuário entrou com 2 ou mais caracteres
                 */
                if(s.length()>=2){
                    if(Float.parseFloat(s.toString()) < healthController.getMAX_PESO()){

                        if(Float.parseFloat(s.toString()) > healthController.getMIN_PESO()){
                            /* caso a entrada passe nas 3 verificações, o boolean pesoValido
                            * é setado para verdadeiro
                            */
                            pesoValido = true;
                        }

                    }
                    /* caso o usuário apague ou altere a entrada, e esta entrada não é válida
                    * para as verificações anteriores, o boolean pesoValido se torna falso
                    * novamente
                    */
                }else{
                    pesoValido = false;

                }

                //Caso altura e peso são válidos, já é mostrado um resultado ao usuário
                if (alturaValida && pesoValido) {
                    healthController.updateActivity(getActivity());
                    healthController.mostrarIMC();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextInputEditText edtAltura = (TextInputEditText) getActivity().findViewById(R.id.imb_altura);
        edtAltura.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Mesmas verificações, só que no campo de altura -------------------------------------------------------------
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int after) {


                if(s.length()==3){

                    if(Float.parseFloat(s.toString()) < healthController.getMAX_ALTURA()){

                        if(Float.parseFloat(s.toString()) > healthController.getMIN_ALTURA()) {
                            alturaValida = true;
                        }


                    }
                }else alturaValida = false;


                if (alturaValida && pesoValido) {
                    healthController.updateActivity(getActivity());
                    healthController.mostrarIMC();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        TextInputEditText edtIdade = (TextInputEditText) getActivity().findViewById(R.id.imb_idade);
        edtAltura.addTextChangedListener(new TextWatcher() {
            //Mesmas verificações, mas no campo de idade -------------------------------------------------------------

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int after) {

                if(s.length()==3){

                    if(Float.parseFloat(s.toString()) < healthController.getMAX_IDADE()){

                        if(Float.parseFloat(s.toString()) > healthController.getMIN_IDADE()) {
                            idadeValida = true;
                        }


                    }
                }else idadeValida = false;


                if (alturaValida && pesoValido && idadeValida) {
                    healthController.updateActivity(getActivity());
                    healthController.mostrarIMC();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        Spinner spinnerSexo = (Spinner) getActivity().findViewById(R.id.imb_sexo_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.imb_sexo_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerSexo.setAdapter(arrayAdapter);

        spinnerSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                }else if(position == 1){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Spinner spinnerExerc = (Spinner) getActivity().findViewById(R.id.freq_exercicios_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        arrayAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.freq_exerc_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerExerc.setAdapter(arrayAdapter);

        spinnerExerc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                }else if(position == 1){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
