package app.com.bugdroidbuilder.paulo.droidhealth.view;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import app.com.bugdroidbuilder.paulo.droidhealth.R;

public class DicasSonoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicas_sono);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_dicas_sono);
        setSupportActionBar(toolbar);
        //Habilita o botão de sair na toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Seta o icone do botao de sair e sua cor
        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        upArrow.setColorFilter(getResources().getColor(R.color.colorTabStrip), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Se clicar para voltar no seta da toolbar, retorna a activity principal
        finish();
        return super.onOptionsItemSelected(item);
    }
}
