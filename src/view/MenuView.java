/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ChevalController;
import controller.CourseController;
import controller.HippodromeController;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import model.Cheval;
import model.Course;
import utilitaire.Utilitaire;

/**
 *
 * @author hugoc
 */
public class MenuView {

    HippodromeController hippodromeController;
    CourseController courseController;
    ChevalController chevalController;
    
    public MenuView() {
        hippodromeController = new HippodromeController();
        courseController = new CourseController();
        chevalController = new ChevalController();
    }

    public MenuView(List<Cheval> chevaux) {
        hippodromeController = new HippodromeController();
        courseController = new CourseController();
        chevalController = new ChevalController();
        
        
         for (Cheval cheval : chevaux) {
            chevalController.creerCheval(cheval.getNom(), cheval.getAge());
        }
    }

    String courseNom;
    Date courseDate;

    String chevalNom;
    int chevalAge;

    public void choixMenu() {
        System.out.println("Quel action souhaitez-vous faire ?");
        System.out.println("1 : Créer une course");
        System.out.println("2 : Voir la liste des courses");
        System.out.println("3 : Modifier une course");
        System.out.println("4 : Supprimer une course");
        System.out.println("5 : Ajouter un cheval");
        System.out.println("6 : Voir la liste des chevaux");
        System.out.println("7 : Modifier un cheval");
        System.out.println("8 : Supprimer un cheval");
        System.out.println("9 : Lancer course");
        System.out.println("10 : Résultats des dix dernières courses");
        switch (Utilitaire.saisieString()) {
            case "1":
                System.out.println("-----------------------------------------------------------");
                System.out.println("1 : Créer une course");
                System.out.println("Saisissez un nom pour la course : ");
                courseNom = Utilitaire.saisieString();
                try {
                    System.out.println("Saisissez une date pour la course au format : JJ/MM/AAAA");
                    courseDate = Utilitaire.saisieDate();
                } catch (Exception e) {
                    System.out.println("Erreur sur la saisie de la date.");
                }
                courseController.creerCourse(courseNom, courseDate);
                System.out.println("-----------------------------------------------------------");
                break;
            case "2":
                System.out.println("-----------------------------------------------------------");
                System.out.println("2 : Voir la liste des courses");
                courseController.voirCourses();
                System.out.println("-----------------------------------------------------------");
                break;
            case "3":
                System.out.println("-----------------------------------------------------------");
                System.out.println("3 : Modifier une course");
                System.out.println("Saisissez le nom de la course à modifier : ");
                String ancienNomCourse = Utilitaire.saisieString();
                System.out.println("Saisissez le nouveau nom de la course : ");
                String nouveauNomCourse = Utilitaire.saisieString();
                Date nouvelleDateCourse = new Date();
                try {
                    System.out.println("Saisissez une date pour la course au format : JJ/MM/AAAA");
                    nouvelleDateCourse = Utilitaire.saisieDate();
                } catch (Exception e) {
                    System.out.println("Erreur sur la saisie de la date.");
                }
                courseController.modifierCourse(ancienNomCourse, nouveauNomCourse, nouvelleDateCourse);
                System.out.println("-----------------------------------------------------------");
                break;
            case "4":
                System.out.println("-----------------------------------------------------------");
                System.out.println("4 : Supprimer une course");
                System.out.println("Saisissez le nom de la course à supprimer : ");
                courseNom = Utilitaire.saisieString();
                courseController.supprimerCourseParNom(courseNom);
                System.out.println("-----------------------------------------------------------");
                break;
            case "5":
                System.out.println("-----------------------------------------------------------");
                System.out.println("5 : Ajouter un cheval");
                System.out.println("Saisissez un nom pour le cheval : ");
                chevalNom = Utilitaire.saisieString();
                System.out.println("Saisissez l'âge du cheval : ");
                chevalAge = Utilitaire.saisieInt();
                chevalController.creerCheval(chevalNom, chevalAge);
                System.out.println("-----------------------------------------------------------");
                break;
            case "6":
                System.out.println("-----------------------------------------------------------");
                System.out.println("6 : Voir la liste des chevaux");
                chevalController.voirChevaux();
                System.out.println("-----------------------------------------------------------");
                break;
            case "7":
                System.out.println("-----------------------------------------------------------");
                System.out.println("7 : Modifier un cheval");
                System.out.println("Saisissez le nom du cheval à modifier : ");
                String ancienNomCheval = Utilitaire.saisieString();
                System.out.println("Saisissez le nouveau nom du cheval : ");
                String nouveauNomCheval = Utilitaire.saisieString();
                System.out.println("Saisissez l'âge du cheval : ");
                int nouvelAgeCheval = Utilitaire.saisieInt();
                chevalController.modifierCheval(ancienNomCheval, nouveauNomCheval, nouvelAgeCheval);
                System.out.println("-----------------------------------------------------------");
                break;
            case "8":
                System.out.println("-----------------------------------------------------------");
                System.out.println("8 : Supprimer un cheval");
                System.out.println("Saisissez le nom du cheval à supprimer : ");
                chevalNom = Utilitaire.saisieString();
                chevalController.supprimerChevalParNom(chevalNom);
                System.out.println("-----------------------------------------------------------");
                break;
            case "9":
                System.out.println("-----------------------------------------------------------");
                 System.out.println("9 : Lancer course");
                System.out.println("Saisissez le nom de la course à lancer : ");
                courseNom = Utilitaire.saisieString();
                Course course = courseController.obtenirCourseParNom(courseNom);
                if (course != null) {
                    Cheval cheval = courseController.lancerCourse(course);
                    if (cheval != null) {
                        chevalController.ajouterVictoireCheval(cheval);
                        hippodromeController.saveResultat(course, cheval);
                    }
                }
                System.out.println("-----------------------------------------------------------");
                break;
            case "10":
                System.out.println("-----------------------------------------------------------");
                System.out.println("10 : Résultats des dix dernières courses");
                hippodromeController.lireDixResultats();
                System.out.println("-----------------------------------------------------------");
                break;
            default:
                break;
        }
    }

}
