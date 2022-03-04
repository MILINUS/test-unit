package controller;

import dao.ChevalDao;
import model.Cheval;
import model.Data;

public class ChevalController {

    ChevalDao chevalDao;

    public ChevalController() {
        chevalDao = new ChevalDao();
    }

    public boolean creerCheval(String nom, int age) {
        // Gestion des erreurs
        if (nom == null || age <= 0 || age > 50) {
            if (age <= 0) {
                System.out.println("Merci d'ajouter un cheval qui peut exister");
            }
            if (age > 50) {
                System.out.println("Votre cheval très certainement mort");
            }
            return false;
        }
        for (Cheval cheval : Data.getChevaux()) {
            if (cheval.getNom().equals(nom)) {
                System.out.println("Un cheval avec le même nom existe déjà");
                return false;
            }
        }
        // -----------------------------------------
        Cheval cheval = new Cheval(nom, age, 0);
        return chevalDao.creerCheval(cheval);
    }

    public void voirChevaux() {
        // Gestion des erreurs
        if (Data.getChevaux().size() == 0) {
            System.out.println("Aucun cheval dans la liste");
        }
        // -----------------------------------------
        for (Cheval cheval : Data.getChevaux()) {
            System.out.println("Nom : " + cheval.getNom() + " | Age : " + cheval.getAge() + " | Nombre de victoire : " + cheval.getNbVictoire());
        }
    }

    public boolean supprimerChevalParNom(String nomCheval) {
        Cheval cheval = chevalDao.getChevalParNom(nomCheval);
        // Gestion des erreurs
        if (cheval == null) {
            System.out.println("Le cheval à supprimer n'existe pas");
            return false;
        }
        // -----------------------------------------
        chevalDao.supprimerCheval(cheval);
        return true;
    }

}
