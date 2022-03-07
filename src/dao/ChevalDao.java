package dao;

import java.util.ArrayList;
import java.util.List;
import model.Cheval;
import model.Data;

public class ChevalDao {
    
    public ChevalDao() {
        Data.setChevaux(new ArrayList<Cheval>());
    }

    public boolean creerCheval(Cheval cheval) {
        return Data.getChevaux().add(cheval);
    }

    public List<Cheval> obtenirCheval() {
        return Data.getChevaux();
    }

    public Cheval getChevalParNom(String nomCheval) {
        Cheval cheval = null;
        for (Cheval c : obtenirCheval()) {
            if (c.getNom().equals(nomCheval)) {
                cheval = c;
            }
        }
        return cheval;
    }

    public boolean supprimerCheval(Cheval cheval) {
        return Data.getChevaux().remove(cheval);
    }

    public boolean modifierCheval(Cheval cheval, String nouveauNomCheval, int nouvelAgeCheval) {
        cheval.setNom(nouveauNomCheval);
        cheval.setAge(nouvelAgeCheval);
        return true;
    }
    
    public boolean ajouterVictoireCheval(Cheval cheval) {
        cheval.setNbVictoire(cheval.getNbVictoire() + 1); 
        return true;
    }
}
