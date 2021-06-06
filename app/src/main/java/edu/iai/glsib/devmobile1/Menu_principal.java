package edu.iai.glsib.devmobile1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.iai.glsib.devmobile1.Model.Matiere;

public class Menu_principal extends AppCompatActivity {

    EditText EdId;
    Button Btn_Qt;
    Button Btn_Act;
    List<Matiere> listmatiere = new ArrayList<>();
    Button btnP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnP = findViewById(R.id.btn_puissance);
        EdId = findViewById(R.id.idMatiere);
        Btn_Qt = findViewById(R.id.btn_rechercher);
        Btn_Act = findViewById(R.id.btn_action);

        registerForContextMenu(Btn_Act);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // le premier contitue la présence d'un sous menu
        // le second constitue le numéro d'ordre
        // le troisième constitue les sous menu
        // le quatrième constitu le texte
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "Ajouter");
        menu.add(Menu.NONE, 2, Menu.NONE, "Modifier");
        menu.add(Menu.NONE, 3, Menu.NONE, "Supprimer");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == 1) {

            Toast.makeText(this, "Vous avez cliqué sur l'item Ajouter", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == 2) {
            Toast.makeText(this, "Vous avez cliqué sur l'item modifier", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == 3) {
            Toast.makeText(this, "Vous avez cliqué sur l'item supprimer", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onContextItemSelected(item);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Btn_Qt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int IdMatiere = Integer.parseInt(EdId.getText().toString());
                Matiere matiere = findMatiere(IdMatiere);

                if(EdId == null){
                    Toast.makeText(getApplicationContext(),"Matière non disponible",Toast.LENGTH_SHORT);
                }
                else{

                    System.out.println(matiere);
                }
            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent puissance = new Intent(Menu_principal.this, MainActivity.class );
                puissance.putExtra("champA", 4);
                startActivity(puissance);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        listmatiere.add(new Matiere(1, "HG", "Histoire Géographie", 4));
        listmatiere.add(new Matiere(2, "SVT", "Science de la vie et de la terre", 8));
        listmatiere.add(new Matiere(3, "SP", "Science Physique", 6));
        listmatiere.add(new Matiere(4, "ECM", "Education physique et morale", 2));
        listmatiere.add(new Matiere(5, "EPS", "Education Sportive", 2));

    }

    public Matiere findMatiere(int id){
        for(Matiere m : listmatiere){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }
}