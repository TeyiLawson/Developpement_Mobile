package edu.iai.glsib.devmobile1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.iai.glsib.devmobile1.Model.Contact;

public class ContactAdapter extends BaseAdapter {

    private List<Contact> contactList;
    private Context ctx;

    public ContactAdapter(List<Contact> contactList, Context ctx) {
        this.contactList = contactList;
        this.ctx = ctx;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return  contactList.size();
    }

    @Override
    public Contact getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ContactHolder ctholder = new ContactHolder();
        convertView = LayoutInflater.from(ctx).inflate(R.layout.contact_list_item, null);

        ctholder.TvNom = convertView.findViewById(R.id.Nom);
        ctholder.TvPrenom = convertView.findViewById(R.id.Prenom);
        ctholder.TvTelephone = convertView.findViewById(R.id.Telephone);

        ctholder.TvNom.setText(getItem(position).getNom());
        ctholder.TvPrenom.setText(getItem(position).getPrenom());
        ctholder.TvTelephone.setText(getItem(position).getTelephone());

        convertView.setTag(ctholder);
        return convertView;
    }

    class ContactHolder{
        ImageView Img;
        TextView TvNom;
        TextView TvPrenom;
        TextView TvTelephone;


    }
}
