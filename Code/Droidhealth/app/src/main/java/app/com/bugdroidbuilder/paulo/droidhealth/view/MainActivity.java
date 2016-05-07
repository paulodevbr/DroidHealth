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
import app.com.bugdroidbuilder.paulo.droidhealth.controller.PreferencesDAO;
import app.com.bugdroidbuilder.paulo.droidhealth.model.Person;

/**
 * Created by paulo on 13/04/16.
 */
public class MainActivity extends AppCompatActivity implements ToolbarInterface {

    PreferencesDAO preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        startToolbar();
        startTabControl();
        this.preferences = new PreferencesDAO(this);
        if(this.preferences.hasDataStored()){
            this.preferences.restoreUserData();
        }

    }


    @Override
    protected void onStop(){
        super.onStop();
        this.preferences.storeUserData();
    }



    /** Initialize system toolbar
     *
     */
    public void startToolbar(){
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /** Initialize and control MainActivity tabs
     *
     */
    private void startTabControl(){
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        // /Add tabs and their respective title
        tabLayout.addTab(tabLayout.newTab().setText("Perfil"));
        tabLayout.addTab(tabLayout.newTab().setText("Dicas"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Set the color of the text in the tab
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorTextTabUnselected), getResources().getColor(R.color.colorTextTabSelected));

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

        // if this option is selected, the app goes to SettingsActivity
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }else if(id == R.id.information_settings){
            startActivity(new Intent(this, InformationActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }






    public static void main(String args) {


    }
}
