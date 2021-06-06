package edu.iai.glsib.devmobile1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnregisterContact extends AppCompatActivity {

    EditText EdNom;
    EditText EdPrenom;
    EditText EdTelephone;
    Button BtnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregister_contact);

        EdNom = findViewById(R.id.Nom);
        EdPrenom = findViewById(R.id.Prenom);
        EdTelephone = findViewById(R.id.Telephone);
        BtnSave = findViewById(R.id.btnEnregistrer);
    }

    @Override
    protected void onResume() {
        super.onResume();

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String valNom = EdNom.getText().toString();
               String valPrenom = EdPrenom.getText().toString();
               String valTelephone = EdTelephone.getText().toString();
            }
        });
    }
}