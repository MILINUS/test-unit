package utilitaire;

import controller.ChevalController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import model.Cheval;

public class Utilitaire {
    
    ChevalController chevalController;
	
    public static String saisieString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public static Date saisieDate() throws ParseException {
        Scanner sc = new Scanner(System.in);
        String sDate = sc.nextLine();
        if (sDate.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
            return f.parse(sDate);
        } else {
            return null;
        }
    }
    
    public static int saisieInt() {
        try {
            Scanner sc = new Scanner(System.in);
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Vous n'avez pas saisie un nombre");
            return 0;
        }  
    }
    
    public static Date obtenirDateDeLaVeille() {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, -1);
        return c.getTime();
    }
    
    public static List<Cheval> lireFichierChevaux() throws FileNotFoundException, IOException {
        String separateur = "/";
        File file = new File("saveChevaux.txt");
        List<Cheval> chevaux = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;
            int nbLigne = 0;
            // On parcourt toutes les lignes du fichier texte
            while ((ligne = br.readLine()) != null) {

                // On découpe la ligne du fichier texte par rapport au slash
                String infoCheval[] = ligne.split(separateur);

                chevaux.add(new Cheval(infoCheval[0], Integer.parseInt(infoCheval[1]), 0));

                nbLigne = ++nbLigne;
            }
        } catch (IOException e) {
            System.out.println("Erreur de lecture");
        }
        return chevaux;
    }
    
}
