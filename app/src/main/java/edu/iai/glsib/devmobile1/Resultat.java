package edu.iai.glsib.devmobile1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultat extends AppCompatActivity {

    String msg;
    Button BtnRetour;
    TextView TvMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);

        BtnRetour = findViewById(R.id.idRetour);
        TvMsg = findViewById(R.id.idmessage);

        Bundle extras = getIntent().getExtras();
        msg = new String(extras.getString("msg"));
    }

    @Override
    protected void onResume() {
        super.onResume();

        TvMsg.setText(msg);

        BtnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rattrapage = new Intent(Resultat.this, Rattrapage.class );
                startActivity(rattrapage);
                finish();
            }
        });


    }
}