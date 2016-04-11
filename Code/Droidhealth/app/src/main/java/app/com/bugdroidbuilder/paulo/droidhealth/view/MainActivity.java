package app.com.bugdroidbuilder.paulo.droidhealth.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import android.support.v7.widget.Toolbar;

import org.w3c.dom.Text;

import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;
import app.com.bugdroidbuilder.paulo.droidhealth.model.CalcHealth;
import app.com.bugdroidbuilder.paulo.droidhealth.R;

public class MainActivity extends AppCompatActivity{
    HealthController healthController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.water_drop_icon_selected)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.food_icon)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.fitness_icon)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0) {
                    tab.setIcon(getResources().getDrawable(R.drawable.water_drop_icon_selected));
                    toolbar.setTitle("Hidratação diária");
                } else if (tab.getPosition() == 1) {
                    tab.setIcon(getResources().getDrawable(R.drawable.food_icon_selected));
                    toolbar.setTitle("Gasto de calorias diário");
                } else if (tab.getPosition() == 2) {
                    tab.setIcon(getResources().getDrawable(R.drawable.fitness_icon_selected));
                    toolbar.setTitle("Índice de massa corporal");
                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    tab.setIcon(getResources().getDrawable(R.drawable.water_drop_icon));
                } else if (tab.getPosition() == 1) {
                    tab.setIcon(getResources().getDrawable(R.drawable.food_icon));
                } else if (tab.getPosition() == 2) {
                    tab.setIcon(getResources().getDrawable(R.drawable.fitness_icon));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    healthController = new HealthController(this);
    }

    public HealthController getHealthController() {
        return healthController;
    }

    public static void main(String args){

    }





}
