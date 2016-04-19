package app.com.bugdroidbuilder.paulo.droidhealth.view.calculator;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;

public class CalcExFisicoFragment extends Fragment {

    private boolean alturaValida = false;
    private boolean pesoValido = false;

    private HealthController healthController = new HealthController(getActivity());
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_ex_fisico, container, false);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        TextInputEditText edtPeso = (TextInputEditText) getActivity().findViewById(R.id.imc_peso);
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
                    //healthController.updateActivity(getActivity());
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
                if(s.length()==3){

                    if(Float.parseFloat(s.toString()) < healthController.getMAX_ALTURA()){

                        if(Float.parseFloat(s.toString()) > healthController.getMIN_ALTURA()) {
                            alturaValida = true;
                        }


                    }
                }else alturaValida = false;


                if (alturaValida && pesoValido) {
                   // healthController.updateActivity(getActivity());
                    healthController.mostrarIMC();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }







}
