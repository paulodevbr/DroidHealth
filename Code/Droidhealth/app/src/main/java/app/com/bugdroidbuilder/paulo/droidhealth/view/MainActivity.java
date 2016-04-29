package app.com.bugdroidbuilder.paulo.droidhealth.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Pessoa;

/**
 * Created by paulo on 13/04/16.
 */
public class MainActivity extends AppCompatActivity{


    private static final String PREFS_NAME = "MyPrefsFile";
    HealthController healthController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        startToolbar();
        startTabControl();
        healthController = new HealthController(this);
        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if(settings.getBoolean("saved", true)){
            restoreUserData(settings);
        }


    }
    private void startToolbar(){
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    private void startTabControl(){
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //Adiciona os ícones às tabs
        tabLayout.addTab(tabLayout.newTab().setText("Perfil"));
        tabLayout.addTab(tabLayout.newTab().setText("Dicas"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            startActivity(new Intent(this, ConfiguracoesActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume(){
        super.onResume();
        healthController.mostrarResumo();

    }
    @Override
    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        if(HealthController.pesoExists()){
            editor.putBoolean("pesoExists", HealthController.pesoExists());
            editor.putString("peso", Pessoa.getPesoString());
            editor.putString("hdrString", Pessoa.getQntAgua());
        }

        // Commit the edits!
        editor.putBoolean("saved", true);
        editor.apply();
    }

    private void restoreUserData(SharedPreferences settings){


        if(settings.getBoolean("pesoExists", true)){
            HealthController.setPesoExists(settings.getBoolean("pesoExists", true));
            Pessoa.setPesoString(settings.getString("peso", Pessoa.getPesoString()));
            Pessoa.setQntAgua(settings.getString("hdrString", Pessoa.getQntAgua()));
        }
    }

    public static void main(String args) {


    }
}
