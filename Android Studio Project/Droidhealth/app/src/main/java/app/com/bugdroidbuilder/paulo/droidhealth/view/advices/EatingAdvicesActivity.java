package app.com.bugdroidbuilder.paulo.droidhealth.view.advices;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.view.ToolbarInterface;

public class EatingAdvicesActivity extends AppCompatActivity implements ToolbarInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advices_eating_activity);
        startToolbar();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // If the user click to go back, the app goes to MainActivity
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void startToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.eating_toolbar);
        toolbar.setTitle(getResources().getString(R.string.eating_name));
        setSupportActionBar(toolbar);
        //Setup the button to quit this activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Set the color of the arrow
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.colorTabStrip), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }
}
