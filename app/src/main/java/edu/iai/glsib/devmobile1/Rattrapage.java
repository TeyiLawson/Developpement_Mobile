package edu.iai.glsib.devmobile1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Rattrapage extends AppCompatActivity {
    String Affichage;
    EditText EdNom;
    EditText EdDate;
    RadioGroup RgS;
    RadioButton RbM;
    RadioButton RbF;
    Button BtnCal;
    Button BtnR;
    TextView TMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rattrapage);

        EdNom = findViewById(R.id.idNomPrenom);
        EdDate = findViewById(R.id.idDatenais);
        RgS = findViewById(R.id.RgSexe);
        RbM = findViewById(R.id.RbMasculin);
        RbF = findViewById(R.id.RbFeminin);
        BtnCal = findViewById(R.id.btn_calculerAge);
        BtnR = findViewById(R.id.idRetour);
        TMsg = findViewById(R.id.idmessage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BtnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //formater le champ edit pour accueillir une date
                DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                Date datenais = null;
                try {
                    datenais = format.parse(EdDate.getText().toString());
                    String majorite = afficherMessage(datenais);
                    String nomPrenom = EdNom.getText().toString();
                    String civilite = laCivilite();
                    Affichage = civilite + " " +nomPrenom+ " " +majorite;
                    //TMsg.setText(Affichage);
                    Intent resultat = new Intent(Rattrapage.this, Resultat.class );
                    resultat.putExtra("msg", Affichage);
                    startActivity(resultat);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public String afficherMessage(Date datenais){

        DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String message1;

        if(date.getYear() - datenais.getYear() < 18){
            message1 = "vous êtes Mineur";
        }
        else{
            message1 = "vous êtes Majeur";
        }

        return message1;
    }

    public String laCivilite(){
        String message2 = "";

        if(RbM.isChecked()){
            message2 = "Mr";
        }else if(RbF.isChecked()){
            message2 = "Mme";
        }
        return message2;
    }

}