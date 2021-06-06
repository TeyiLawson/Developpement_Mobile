package edu.iai.glsib.devmobile1;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import edu.iai.glsib.devmobile1.Model.Contact;
import utils.DbAccess;

public class ContactDAO {

    public boolean save(DbAccess dbAccess, Contact contact){
        ContentValues  cv = new ContentValues();
        cv.put("NOM",contact.getNom());
        cv.put("PRENOM",contact.getPrenom());
        cv.put("TELEPHONE",contact.getTelephone());
        long nbLigne = dbAccess.getDatabase().insert("Contact",null,cv);
        if(nbLigne > 0)
            return true;
        else
            return false;
    }

    public List<Contact> getAll(DbAccess dbAccess){

        List<Contact> ListeContact = new ArrayList<>();
        String requete = "SELECT * FROM Contact;";
        Cursor curseur = dbAccess.getDatabase().rawQuery(requete,null);
        if (curseur != null){
            while (curseur.moveToNext()){
                Contact c = new Contact();
                c.setId(curseur.getInt(0));
                c.setNom(curseur.getString(1));
                c.setPrenom(curseur.getString(2));
                c.setTelephone(curseur.getString(3));

                ListeContact.add(c);
            }
        }
        return ListeContact;
    }

}
