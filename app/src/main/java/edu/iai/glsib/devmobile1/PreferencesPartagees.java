package edu.iai.glsib.devmobile1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PreferencesPartagees extends AppCompatActivity {

    EditText Ed1;
    EditText Ed2;
    EditText Ed3;
    Button Btn_souvenir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_partagees);

        Ed1 = findViewById(R.id.id1);
        Ed2 = findViewById(R.id.id2);
        Ed3 = findViewById(R.id.id3);
        Btn_souvenir = findViewById(R.id.Souvenir);
    }

    // Stocker les préférences partagées
    private void seSouvenir(){
        String val1 = Ed1.getText().toString();
        String val2 = Ed2.getText().toString();
        String val3 = Ed3.getText().toString();

        SharedPreferences numPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = numPref.edit();
        editor.putString("champ1", val1);
        editor.putString("champ2", val2);
        editor.putString("champ3", val3);
        editor.commit();
    }

    // afficher automatiquement les préférences partagées
    private void loadPrefs(){
        SharedPreferences numPref = PreferenceManager.getDefaultSharedPreferences(this);
        String num1 = numPref.getString("champ1", null);
        String num2 = numPref.getString("champ2", null);
        String num3 = numPref.getString("champ3", null);
        Ed1.setText(num1);
        Ed2.setText(num2);
        Ed3.setText(num3);
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadPrefs();

        Btn_souvenir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seSouvenir();
            }
        });
    }
}