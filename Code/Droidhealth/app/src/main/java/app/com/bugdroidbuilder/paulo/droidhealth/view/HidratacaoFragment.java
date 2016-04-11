package app.com.bugdroidbuilder.paulo.droidhealth.view;

import android.app.Activity;
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
import android.widget.EditText;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;


public class HidratacaoFragment extends Fragment {
    private TextInputEditText edtPeso;
    private boolean pesoValido = false;
    private HealthController healthController = new HealthController(getActivity());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hidratacao, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        edtPeso = (TextInputEditText)getActivity().findViewById(R.id.hdr_peso);
        edtPeso.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                   pesoValido = true;
                }else pesoValido = false;

                if(pesoValido){
                    healthController.updateActivity(getActivity());
                    healthController.mostrarHDR();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}
