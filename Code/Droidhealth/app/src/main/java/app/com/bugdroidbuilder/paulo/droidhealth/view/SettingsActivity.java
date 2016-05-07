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

public class SettingsActivity extends AppCompatActivity implements ToolbarInterface{

    private final int MAX_HEIGHT = 260;
    private final int MIN_HEIGHT = 100;

    private final int MAX_AGE = 120;
    private final int MIN_AGE = 15;

    private final int MAX_WEIGHT = 400;
    private final int MIN_WEIGHT = 30;



    private boolean validWeight = false;
    private boolean validHeight = false;
    private boolean validAge = false;

    HealthController healthController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        startToolbar();
        startEdtWeightListener();
        startEdtHeightListener();
        startEdtAgeListener();
        startSpinnerGender();
        startSpinnerExerc();
        healthController = new HealthController();


    }
    @Override
    public void onResume(){
        //When entering this activity set all values to false, in order to avoid taking invalid information
        super.onResume();
        this.validWeight = HealthController.weightExists();
        this.validHeight = HealthController.heightExists();
        this.validAge = HealthController.ageExists();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // If the user touch in the toolbar arrow, finish this activity and go back to main
        finish();
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void startToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_configuracoes);
        setSupportActionBar(toolbar);
        //Habilita o botão de sair na toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Seta o icone do botao de sair e sua cor
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.colorTabStrip), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    /** Start a listener to verify when the editText weight is changed by user
     *
     */
    public void startEdtWeightListener(){
        TextInputEditText edtWeight = (TextInputEditText) findViewById(R.id.settings_weight_edt);
        // check if the weight was already set
        if(HealthController.weightExists()){
            edtWeight.setText(Integer.toString(Person.getWeight()));
        }

        edtWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                /* check if the weight is higher than min and lower than max
                 * and if the user entered with 2 or more digits
                 */

                if(s.length()>=2){

                    if(Integer.parseInt(s.toString())<MAX_WEIGHT){

                        if(Integer.parseInt(s.toString()) > MIN_WEIGHT){
                            /* If the entering data pass through these 3 verifications, validWeight
                            * is set to true
                            */
                            validWeight = true;
                        }

                    }
                    /* if the user erase or change the data and it is not valid
                    * validWeight is set to false again
                    */
                }else{
                    validWeight = false;

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    /** Start a listener to verify when the editText height is changed by user
     *
     */
    public void startEdtHeightListener(){
        TextInputEditText edtHeight = (TextInputEditText)findViewById(R.id.settings_height_edt);

        if(HealthController.weightExists()){
            edtHeight.setText(Integer.toString(Person.getHeight()));
        }

        edtHeight.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Same verifications, but in editText for height
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int after) {

                /* check if the height is higher than min and lower than max
                 * and if the user entered with 3 or more digits
                 */
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
    }
    /** Start a listener to verify when the editText age is changed by user
     *
     */
    public void startEdtAgeListener(){
        TextInputEditText edtAge = (TextInputEditText) findViewById(R.id.settings_age_edt);

        if(HealthController.weightExists()){
            edtAge.setText(Integer.toString(Person.getAge()));
        }

        edtAge.addTextChangedListener(new TextWatcher() {
            //Same verifications, but in editText for age

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
    }

    /** Start the spinner to choose the gender
     *
     */
    public void startSpinnerGender(){
        final Spinner spinnerGender = (Spinner) findViewById(R.id.settings_gender_spinner);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.bmr_gender_array, android.R.layout.simple_spinner_item);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerGender.setAdapter(arrayAdapter);

        //verify if this spinner was already set, and if yes, set to the previous item selected
        if(HealthController.weightExists() || HealthController.heightExists()
                || HealthController.ageExists()){
            int position = arrayAdapter.getPosition(Person.getGender());
            spinnerGender.setSelection(position);
        }
        // if some item is selected, store the selected value
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Person.setGender(spinnerGender.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /** Start the spinner to choose the frequency of physical activities
     *
     */
    private void startSpinnerExerc(){
        final Spinner spinnerExerc = (Spinner) findViewById(R.id.settings_physical_act_spinner);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,
                R.array.freq_exerc_array, android.R.layout.simple_spinner_item);



        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExerc.setAdapter(arrayAdapter);

        //verify if this spinner was already set, and if yes, set to the previous item selected
        if(HealthController.weightExists() || HealthController.heightExists()
                || HealthController.ageExists()){

            int position = arrayAdapter.getPosition(Person.getQntPhysicalActivies());
            spinnerExerc.setSelection(position);
        }


        spinnerExerc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // if some item is selected, store the selected value
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Person.setQntPhysicalActivies(spinnerExerc.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /** Save the information entered by the user
     *
     * @param view Floating Action Button saveSettings
     */
    public void saveSettings(View view) {

        EditText edtWeight = (EditText) findViewById(R.id.settings_weight_edt);
        EditText edtHeight = (EditText) findViewById(R.id.settings_height_edt);
        EditText edtAge = (EditText) findViewById(R.id.settings_age_edt);

        //Verify if the information entered is valid

        if (validWeight) {
            Person.setWeight(Integer.parseInt(edtWeight.getText().toString()));
            HealthController.setWeightExists(validWeight);
        }
        if (validHeight) {
            Person.setHeight(Integer.parseInt(edtHeight.getText().toString()));
            HealthController.setHeightExists(validHeight);
        }

        if (validAge) {
            Person.setAge(Integer.parseInt(edtAge.getText().toString()));
            HealthController.setAgeExists(validAge);
        }
        finish();

    }


}
