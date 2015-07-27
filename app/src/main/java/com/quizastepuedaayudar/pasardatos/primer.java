package com.quizastepuedaayudar.pasardatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class primer extends AppCompatActivity {

    private static final int REQUEST_CODE = 10;
    EditText txtnombre;
    EditText txtn1;
    EditText txtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primer_activity);
        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtn1 = (EditText) findViewById(R.id.txtn1);
        txtn2 = (EditText) findViewById(R.id.txtnota2);
    }

    public void abrirActivity(View view)
    {
           Intent i = new Intent(getApplicationContext(),Segundo.class);
           String nombre = txtnombre.getText().toString();
           int n1  = Integer.valueOf(txtn1.getText().toString());
           int n2 = Integer.valueOf(txtn2.getText().toString());
           Alumno al = new Alumno(n1,n2,nombre);
           i.putExtra("pasarvalor",al);
           startActivityForResult(i, REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            if (data.hasExtra("suma"))
            {
                Toast.makeText(getApplicationContext(),"La suma es " + data.getExtras().getInt("suma") ,Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_primer, menu);
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
