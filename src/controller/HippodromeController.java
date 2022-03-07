/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import model.Cheval;
import model.Course;

/**
 *
 * @author hugoc
 */
public class HippodromeController {

    public boolean saveResultat(Course course, Cheval cheval) {
        try {
            List<String> listContent = new ArrayList<>();
            listContent.add(course.getNom() + "/" + cheval.getNom());
            listContent.addAll(obtenirDixResultats());

            File file = new File("victoiresCourses.txt");

            // -- Créer le fichier s'il n'existe pas
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String content : listContent) {
                bw.write(content);
                bw.write("\r\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Erreur de sauvegarde");
            return false;
        }
        return true;
    }

    public boolean lireDixResultats() {
        String separateur = "/";
        File file = new File("victoiresCourses.txt");

        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;
            int nbLigne = 0;
            // On parcourt toutes les lignes du fichier texte
            while ((ligne = br.readLine()) != null) {

                if (nbLigne < 10) {
                    // On découpe la ligne du fichier texte par rapport au slash
                    String infoCourse[] = ligne.split(separateur);

                    System.out.println(infoCourse[1] + " à gagner " + infoCourse[0]);

                    nbLigne = ++nbLigne;
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur de lecture");
            return false;
        }
        return true;
    }

    public List<String> obtenirDixResultats() {
        String separateur = "/";
        File file = new File("victoiresCourses.txt");
        List<String> resultats = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;
            int nbLigne = 0;
            // On parcourt toutes les lignes du fichier texte
            while ((ligne = br.readLine()) != null) {

                if (nbLigne < 10) {
                    // On découpe la ligne du fichier texte par rapport au slash
                    String infoCourse[] = ligne.split(separateur);

                    resultats.add(infoCourse[0] + "/" + infoCourse[1]);

                    nbLigne = ++nbLigne;
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur de lecture");
        }
        return resultats;
    }
}
