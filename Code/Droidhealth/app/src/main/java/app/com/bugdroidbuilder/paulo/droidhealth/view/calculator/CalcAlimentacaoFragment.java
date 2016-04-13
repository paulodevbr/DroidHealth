package app.com.bugdroidbuilder.paulo.droidhealth.view.calculator;

import android.content.Context;
import android.net.Uri;
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
import android.widget.Toast;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;


public class CalcAlimentacaoFragment extends Fragment {

    private boolean pesoValido = false;
    private boolean alturaValida = false;
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
                    if(Float.parseFloat(s.toString()) < CalcHealth.getMAX_PESO()){

                        if(Float.parseFloat(s.toString()) > CalcHealth.getMIN_PESO()){
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

        TextInputEditText edtAltura = (TextInputEditText) getActivity().findViewById(R.id.imc_altura);
        edtAltura.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int after) {

                //Mesmas verificações, só que no campo de altura
                if(s.length()>=3){

                    if(Float.parseFloat(s.toString()) < CalcHealth.getMAX_ALTURA()){

                        if(Float.parseFloat(s.toString()) > CalcHealth.getMIN_ALTURA()) {
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
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.imb_sexo_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.imb_sexo_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(getContext(),"masculino selecionado",Toast.LENGTH_SHORT).show();
                }else if(position == 1){
                    Toast.makeText(getContext(),"feminino selecionado",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
