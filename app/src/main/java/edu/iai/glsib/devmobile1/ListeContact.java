package edu.iai.glsib.devmobile1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import edu.iai.glsib.devmobile1.Model.Contact;

public class ListeContact extends AppCompatActivity {

    private ContactAdapter cta;
    private List<Contact> contactList;
    ListView Ltv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        Ltv = findViewById(R.id.LvContact);
        addContact();
        cta = new ContactAdapter(contactList, this);
        Ltv.setAdapter(cta);
        cta.notifyDataSetChanged();
    }

    void addContact(){
        contactList = new ArrayList<>();
        contactList.add(new Contact(1, "ABALO", "Koffi", "98754217", 1 ));
        contactList.add(new Contact(2, "BATCHO", "Jean", "758464", 1 ));
        contactList.add(new Contact(3, "GABA", "Afi", "1247850", 1 ));
        contactList.add(new Contact(4, "DEGBO", "Yovo", "98754217", 1 ));
    }
}
