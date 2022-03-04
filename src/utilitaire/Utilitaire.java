package utilitaire;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Utilitaire {
	
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
}
