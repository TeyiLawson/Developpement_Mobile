package edu.iai.glsib.devmobile1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText chA;
    EditText chN;
    EditText chR;
    Button btnCAL;
    Button btnEFF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        chA = findViewById(R.id.champa);
        chN = findViewById(R.id.champn);
        chR = findViewById(R.id.champr);
        btnCAL =findViewById(R.id.btn_calculer);
        btnEFF =findViewById(R.id.btn_effacer);
    }

    private long puissance(int a, int n){
        long result = 1;
        for(int i=1; i<=n; i++){
            result *=a;
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_ajouter) {

            Toast.makeText(this, "Vous avez cliqué sur l'item Ajouter", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_modifier) {
            Toast.makeText(this, "Vous avez cliqué sur l'item modifier", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_supprimer) {
            Toast.makeText(this, "Vous avez cliqué sur l'item supprimer", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCAL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valA=chA.getText().toString();
                String valN=chN.getText().toString();
                int valAInt=Integer.parseInt(valA);
                int valNInt=Integer.parseInt(valN);
                long  res=puissance(valAInt,valNInt);
                chR.setText(String.valueOf(res));
            }
        });

        btnEFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chA.setText(null);
                chN.setText(null);
                chR.setText(null);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}