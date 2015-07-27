package com.quizastepuedaayudar.pasardatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Segundo extends AppCompatActivity {

    Alumno alumno;
    TextView txtvalor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        txtvalor = (TextView) findViewById(R.id.txtvalor);
        alumno = getIntent().getParcelableExtra("pasarvalor");
        txtvalor.setText(alumno.getNombre() +  ","  + alumno.getN1() + "," + alumno.getN2());
    }

    @Override
    public void finish() {
        Intent i = new Intent();
        int resultado = alumno.getN1() + alumno.getN2();
        i.putExtra("suma",resultado);
        setResult(RESULT_OK,i);
        super.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_segundo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
