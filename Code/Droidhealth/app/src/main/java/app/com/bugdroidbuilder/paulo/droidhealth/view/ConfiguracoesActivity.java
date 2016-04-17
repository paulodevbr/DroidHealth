package app.com.bugdroidbuilder.paulo.droidhealth.view;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Pessoa;

public class ConfiguracoesActivity extends AppCompatActivity{

    private boolean pesoValido = false;
    private boolean alturaValida = false;
    private boolean idadeValida = false;
    HealthController healthController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracoes_activity);
        //Instancia a toolbar da activity
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_configuracoes);
        setSupportActionBar(toolbar);
        //Habilita o botão de sair na toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Seta o icone do botao de sair e sua cor
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.colorTabStrip), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        healthController = new HealthController(this);

        TextInputEditText edtPeso = (TextInputEditText) findViewById(R.id.config_peso);
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
                    if(Integer.parseInt(s.toString()) < healthController.getMAX_PESO()){

                        if(Integer.parseInt(s.toString()) > healthController.getMIN_PESO()){
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
                if(pesoValido = true){
                    Pessoa.setPeso(Integer.parseInt(s.toString()));
                    HealthController.setPesoExists(pesoValido);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextInputEditText edtAltura = (TextInputEditText)findViewById(R.id.config_altura);
        edtAltura.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Mesmas verificações, só que no campo de altura -------------------------------------------------------------
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int after) {


                if(s.length()==3){

                    if(Integer.parseInt(s.toString()) < healthController.getMAX_ALTURA()){

                        if(Integer.parseInt(s.toString()) > healthController.getMIN_ALTURA()) {
                            alturaValida = true;
                        }


                    }
                }else alturaValida = false;

                if(alturaValida = true){
                    Pessoa.setAltura(Integer.parseInt(s.toString()));
                    HealthController.setAlturaExists(alturaValida);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        TextInputEditText edtIdade = (TextInputEditText) findViewById(R.id.config_idade);
        edtIdade.addTextChangedListener(new TextWatcher() {
            //Mesmas verificações, mas no campo de idade -------------------------------------------------------------

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int after) {

                if(s.length()>1){

                    if(Integer.parseInt(s.toString()) < healthController.getMAX_IDADE()){

                        if(Integer.parseInt(s.toString()) > healthController.getMIN_IDADE()) {
                            idadeValida = true;
                        }


                    }
                }else idadeValida = false;

                if(idadeValida = true){
                    Pessoa.setIdade(Integer.parseInt(s.toString()));
                    HealthController.setIdadeExists(idadeValida);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        final Spinner spinnerSexo = (Spinner) findViewById(R.id.config_sexo_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.imb_sexo_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerSexo.setAdapter(arrayAdapter);

        spinnerSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Pessoa.setSexo(spinnerSexo.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner spinnerExerc = (Spinner) findViewById(R.id.config_exercicios_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.freq_exerc_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerExerc.setAdapter(arrayAdapter);

        spinnerExerc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Pessoa.setSexo(spinnerExerc.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }



}
