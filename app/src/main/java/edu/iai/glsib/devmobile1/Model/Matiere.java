package edu.iai.glsib.devmobile1.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Matiere implements Parcelable {
    private int id;
    private String libelle;
    private String description;
    private int coef;

    public Matiere() {
    }

    public Matiere(int id, String libelle, String description, int coef) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.coef = coef;
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", description='" + description + '\'' +
                ", coef=" + coef +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.getId());
        dest.writeString(this.getLibelle());
        dest.writeString(this.getDescription());
        dest.writeInt(this.getCoef());
    }


    public static final Creator<Matiere> CREATOR = new Creator<Matiere>() {
        @Override
        public Matiere createFromParcel(Parcel source) {
            return new Matiere(source);
        }

        @Override
        public Matiere[] newArray(int size) {
            return new Matiere[size];
        }
    };
    public Matiere(Parcel parcel){
        this.setId(parcel.readInt());
        this.setLibelle(parcel.readString());
        this.setDescription(parcel.readString());
        this.setCoef(parcel.readInt());
    }

}
