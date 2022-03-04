package model;

public class Cheval {

    public String nom;
    public int age;
    public int nbVictoire;

    public Cheval(String nom, int age, int nbVictoire) {
        this.nom = nom;
        this.age = age;
        this.nbVictoire = nbVictoire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNbVictoire() {
        return nbVictoire;
    }

    public void setNbVictoire(int nbVictoire) {
        this.nbVictoire = nbVictoire;
    }

}
