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
import android.widget.EditText;
import android.widget.Spinner;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Person;

public class SettingsActivity extends AppCompatActivity{

    private final int MIN_HEIGHT = 100;
    private final int MAX_AGE = 120;
    private final int MIN_AGE = 5;
    private final int MAX_WEIGHT = 400;
    private final int MAX_HEIGHT = 260;
    private final int MIN_WEIGHT = 30;

    private boolean validWeight = false;
    private boolean validHeight = false;
    private boolean validAge = false;

    HealthController healthController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
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

        TextInputEditText edtPeso = (TextInputEditText) findViewById(R.id.settings_weight_edt);
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
                    if(Integer.parseInt(s.toString()) < MAX_WEIGHT){

                        if(Integer.parseInt(s.toString()) > MIN_WEIGHT){
                            /* caso a entrada passe nas 3 verificações, o boolean validWeight
                            * é setado para verdadeiro
                            */
                            validWeight = true;
                        }

                    }
                    /* caso o usuário apague ou altere a entrada, e esta entrada não é válida
                    * para as verificações anteriores, o boolean validWeight se torna falso
                    * novamente
                    */
                }else{
                    validWeight = false;

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextInputEditText edtAltura = (TextInputEditText)findViewById(R.id.settings_height_edt);
        edtAltura.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Mesmas verificações, só que no campo de altura -------------------------------------------------------------
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int after) {


                if(s.length()==3){

                    if(Integer.parseInt(s.toString()) < MAX_HEIGHT){

                        if(Integer.parseInt(s.toString()) > MIN_HEIGHT){
                            validHeight = true;
                        }


                    }
                }else validHeight = false;



            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        TextInputEditText edtIdade = (TextInputEditText) findViewById(R.id.settings_age_edt);
        edtIdade.addTextChangedListener(new TextWatcher() {
            //Mesmas verificações, mas no campo de idade -------------------------------------------------------------

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int after) {

                if(s.length()>1){

                    if(Integer.parseInt(s.toString()) < MAX_AGE){

                        if(Integer.parseInt(s.toString()) > MIN_AGE) {
                            validAge = true;
                        }


                    }
                }else validAge = false;

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        final Spinner spinnerSexo = (Spinner) findViewById(R.id.settings_gender_spinner);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.imb_sexo_array, android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerSexo.setAdapter(arrayAdapter);

        spinnerSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Person.setGender(spinnerSexo.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Spinner spinnerExerc = (Spinner) findViewById(R.id.settings_physical_act_spinner);

        arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.freq_exerc_array, android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExerc.setAdapter(arrayAdapter);

        spinnerExerc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Person.setQntPhysicalActivies(spinnerExerc.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
        this.validWeight = false;
        this.validHeight = false;
        this.validAge = false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Se clicar para voltar no seta da toolbar, retorna a activity principal
        finish();
        return super.onOptionsItemSelected(item);
    }


    public void save(View view){

        EditText edtWeight = (EditText) findViewById(R.id.settings_weight_edt);
        EditText edtHeight = (EditText) findViewById(R.id.settings_height_edt);
        EditText edtAge = (EditText) findViewById(R.id.settings_age_edt);

        if(validWeight){
            Person.setWeight(Integer.parseInt(edtWeight.getText().toString()));
            HealthController.setWeightExists(validWeight);
        }
        if(validHeight){
            Person.setHeight(Integer.parseInt(edtHeight.getText().toString()));
            HealthController.setHeightExists(validHeight);
        }

        if(validAge){
            Person.setAge(Integer.parseInt(edtAge.getText().toString()));
            HealthController.setAgeExists(validAge);
        }
        finish();

    }


}
