package edu.iai.glsib.devmobile1.Model;

public class Contact {

    private long id;
    private String nom;
    private String prenom;
    private String telephone;
    private int image;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Contact() {
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getImage() {
        return image;
    }

    public Contact(int id, String nom, String prenom, String telephone, int image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", telephone='" + telephone + '\'' +
                ", image=" + image +
                '}';
    }
}
