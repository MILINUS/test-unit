package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Cheval;
import model.Data;
import model.Hippodrome;
import utilitaire.Utilitaire;

public class Menu {
    
    

    public static void main(String[] args) throws IOException {
        Hippodrome hippodrome = new Hippodrome();

        // --- Initialisation de départ
        List<Cheval> initChevaux = Utilitaire.lireFichierChevaux();
        // ---
        
        MenuView menuView = new MenuView(initChevaux);
        while (true) {
            menuView.choixMenu();
        }
    }

}
