/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.CourseController;
import utilitaire.Utilitaire;

/**
 *
 * @author hugoc
 */
public class MenuView {

    CourseController courseController;

    public MenuView() {
        courseController = new CourseController();
    }
    
    String courseNom;
    
    public void choixMenu() {
        System.out.println("Quel action souhaitez-vous faire ?");
        System.out.println("1 : Créer une course");
        switch (Utilitaire.saisieString()) {
            case "1":
                System.out.println("1 : Créer une course");
                System.out.println("Saisissez un nom pour la course : ");
                courseNom = Utilitaire.saisieString();
                break;
            default:
                break;
        }
    }
    
}
