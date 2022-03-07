package controller;

import dao.ChevalDao;
import java.util.List;
import model.Cheval;
import model.Data;

public class ChevalController {

    ChevalDao chevalDao;

    public ChevalController() {
        chevalDao = new ChevalDao();
    }

    public boolean creerCheval(String nomCheval, int ageCheval) {
        // Gestion des erreurs
        if (nomCheval == null || ageCheval <= 0 || ageCheval > 50) {
            if (ageCheval <= 0) {
                System.out.println("Merci d'ajouter un cheval qui peut exister");
            }
            if (ageCheval > 50) {
                System.out.println("Votre cheval très certainement mort");
            }
            return false;
        }
        for (Cheval cheval : Data.getChevaux()) {
            if (cheval.getNom().equals(nomCheval)) {
                System.out.println("Un cheval avec le même nom existe déjà");
                return false;
            }
        }
        // -----------------------------------------
        Cheval cheval = new Cheval(nomCheval, ageCheval, 0);
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
        return chevalDao.supprimerCheval(cheval);
    }
    
    public boolean modifierCheval(String ancienNomCheval, String nouveauNomCheval, int nouvelAgeCheval) {
        Cheval cheval = chevalDao.getChevalParNom(ancienNomCheval);
        // Gestion des erreurs
        if (cheval == null) {
            System.out.println("Le cheval à modifier n'existe pas");
            return false;
        }
        if (nouveauNomCheval == null || nouvelAgeCheval <= 0 || nouvelAgeCheval > 50) {
            if (nouvelAgeCheval <= 0) {
                System.out.println("Merci d'ajouter un cheval qui peut exister");
            }
            if (nouvelAgeCheval > 50) {
                System.out.println("Votre cheval très certainement mort");
            }
            return false;
        }
        for (Cheval c : Data.getChevaux()) {
            if (c.getNom().equals(nouveauNomCheval)) {
                System.out.println("Un cheval avec le même nom existe déjà");
                return false;
            }
        }
        // -----------------------------------------
        return chevalDao.modifierCheval(cheval, nouveauNomCheval, nouvelAgeCheval);
    }
    
    
    public boolean ajouterVictoireCheval(Cheval cheval) {
        return chevalDao.ajouterVictoireCheval(cheval);
    }
}
