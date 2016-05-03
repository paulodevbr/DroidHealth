package app.com.bugdroidbuilder.paulo.droidhealth.controller;

import android.app.Activity;
import android.content.SharedPreferences;

import app.com.bugdroidbuilder.paulo.droidhealth.model.Person;

/**
 *
 */
public class PreferencesDAO {

    public static final String PREFS_NAME = "MyPrefsFile";
    public static SharedPreferences settings;
    SharedPreferences.Editor editor;

    private final Activity activity;

    public PreferencesDAO(Activity _activity){
        this.activity = _activity;
        this.settings = activity.getSharedPreferences(PREFS_NAME, 0);
    }

    public boolean hasDataStored(){
        return settings.getBoolean("saved", false);
    }

    public void storeUserData(){
        SharedPreferences.Editor editor = settings.edit();
        if(HealthController.weightExists()){

            editor.putBoolean("weightExists", HealthController.weightExists());
            editor.putFloat("weight", Person.getWeight());
            editor.putFloat("hdr", Person.getHDR());

            if(HealthController.heightExists()) {

                editor.putBoolean("heightExists", HealthController.heightExists());
                editor.putFloat("height", Person.getHeight());
                editor.putFloat("bmi", Person.getBMI());

                if(HealthController.heightExists()) {

                    editor.putBoolean("ageExists", HealthController.ageExists());
                    editor.putInt("age", Person.getAge());
                    editor.putString("gender", Person.getGender());
                    editor.putString("qntPhysicalExerc", Person.getQntPhysicalActivies());
                    editor.putFloat("bmr", Person.getBMR());

                }
            }
        }

        // Commit the edits!
        editor.putBoolean("saved", true);
        editor.apply();
    }

    /** Restore persistent user data
     *
     */
    public void restoreUserData(){
        boolean weightExists = settings.getBoolean("weightExists", false);

        if(weightExists){
            HealthController.setWeightExists(true);
            Person.setWeight(settings.getFloat("weight", 0));
            Person.setHDR(settings.getFloat("hdr", 0));

            boolean heightExists = settings.getBoolean("heightExists", false);

            if(heightExists){
                HealthController.setHeightExists(true);
                Person.setHeight(settings.getFloat("height", 0));
                Person.setBMI(settings.getFloat("bmi", 0));

                boolean ageExists = settings.getBoolean("ageExists", false);

                if(ageExists){
                    HealthController.setAgeExists(true);
                    Person.setAge(settings.getInt("age", 0));
                    Person.setGender(settings.getString("gender", null));
                    Person.setQntPhysicalActivies(settings.getString("qntPhysicalExerc",null));
                    Person.setBMR(settings.getFloat("bmr", 0));
                }
            }
        }

    }

}
