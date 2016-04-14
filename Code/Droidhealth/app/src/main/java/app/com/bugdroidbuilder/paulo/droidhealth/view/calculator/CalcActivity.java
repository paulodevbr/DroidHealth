package app.com.bugdroidbuilder.paulo.droidhealth.view.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;

/**
 * Created by paulo on 13/04/16.
 */
public class CalcActivity extends AppCompatActivity{


    HealthController healthController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_activity);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);


        //Adiciona os ícones às tabs
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
            //Altera para um ícone mais claro na tab selecionada, e altera o título da toobar
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

            //volta ao ícone alterior caso outra tab seja selecionada
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

    public static void main(String args) {

    }
}
