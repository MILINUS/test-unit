package model;

import java.util.Date;
import java.util.List;

public class Course {

    public String nom;
    public Date date;
    public List<Cheval> chevaux;

    public Course(String nom, Date date, List<Cheval> chevaux) {
        this.nom = nom;
        this.date = date;
        this.chevaux = chevaux;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Cheval> getChevaux() {
        return chevaux;
    }

    public void setChevaux(List<Cheval> chevaux) {
        this.chevaux = chevaux;
    }
}
