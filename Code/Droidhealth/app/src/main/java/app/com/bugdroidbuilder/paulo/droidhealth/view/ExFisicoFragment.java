package app.com.bugdroidbuilder.paulo.droidhealth.view;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;

public class ExFisicoFragment extends Fragment {

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
        edtPeso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    pesoValido = true;
                } else pesoValido = false;

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
                if (s.length() > 0) {
                    alturaValida = true;
                } else alturaValida = false;

                if (alturaValida && pesoValido) {
                    healthController.updateActivity(getActivity());
                    healthController.mostrarIMC();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }







}
