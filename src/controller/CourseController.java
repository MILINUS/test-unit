package controller;

import dao.CourseDao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import model.Cheval;
import model.Course;
import model.Data;
import utilitaire.Utilitaire;

public class CourseController {

    CourseDao courseDao;

    public CourseController() {
        courseDao = new CourseDao();
    }

    public boolean creerCourse(String nom, Date date) {
        // Gestion des erreurs
        if (nom == null || date == null) {
            System.out.println("Erreur dans la création de la course");
            return false;
        }
        if (date.before(Utilitaire.obtenirDateDeLaVeille())) {
            System.out.println("La course à déjà eu lieu");
            System.out.println("Veuillez saisir une autre date");
            return false;
        }
        if (Data.getChevaux().size() < 6) {
            System.out.println("Il manque des chevaux pour créer une course");
            System.out.println("Veuillez créer au moins 6 chevaux auparavant");
            return false;
        }
        // -----------------------------------------
        System.out.println("Pas d'inquiétude les chevaux sont venus s'inscrire seul à la course");

        List<Cheval> chevaux = new ArrayList<>();
        List<Cheval> listChevauxTemp = new ArrayList<>();
        listChevauxTemp.addAll(Data.getChevaux());

        while (chevaux.size() != 6) {
            Cheval chevalRandom = listChevauxTemp.get(new Random().nextInt(listChevauxTemp.size()));

            chevaux.add(chevalRandom);
            listChevauxTemp.remove(chevalRandom);
        }

        Course course = new Course(nom, date, chevaux);
        return courseDao.creerCourse(course);
    }

    public void voirCourses() {
        // Gestion des erreurs
        if (Data.getCourses().size() == 0) {
            System.out.println("Aucune course dans la liste");
        }
        // -----------------------------------------
        for (Course course : Data.getCourses()) {
            System.out.println("Nom course : " + course.getNom() + " | Date : " + course.getDate());
            System.out.println("Chevaux : ");
            for (Cheval cheval : course.getChevaux()) {
                System.out.println("Nom : " + cheval.getNom() + " | Age : " + cheval.getAge() + " | Victoire : " + cheval.getNbVictoire());
            }
            System.out.println("");
        }
    }

    public boolean supprimerCourseParNom(String nomCourse) {
        Course course = courseDao.getCourseParNom(nomCourse);
        // Gestion des erreurs
        if (course == null) {
            System.out.println("La course à supprimer n'existe pas");
            return false;
        }
        // -----------------------------------------
        return courseDao.supprimerCourse(course);
    }

    public boolean modifierCourse(String ancienNomCourse, String nouveauNomCourse, Date nouvelleDateCourse) {
        Course course = courseDao.getCourseParNom(ancienNomCourse);
        // Gestion des erreurs
        if (course == null) {
            System.out.println("La course à modifier n'existe pas");
            return false;
        }
        if (nouvelleDateCourse == null || nouvelleDateCourse == null) {
            System.out.println("Erreur dans la modification de la course");
            return false;
        }
        if (nouvelleDateCourse.before(Utilitaire.obtenirDateDeLaVeille())) {
            System.out.println("La course à déjà eu lieu");
            System.out.println("Veuillez saisir une autre date");
            return false;
        }
        if (Data.getChevaux().size() < 6) {
            System.out.println("Il manque des chevaux pour créer une course");
            System.out.println("Veuillez créer au moins 6 chevaux auparavant");
            return false;
        }
        // -----------------------------------------
        return courseDao.modifierCourse(course, nouveauNomCourse, nouvelleDateCourse);
    }
    
    public Cheval lancerCourse(Course course) { 
        Cheval cheval = course.getChevaux().get(new Random().nextInt(course.getChevaux().size()));
        System.out.println("La course a été lancée correctement");
        System.out.println("Et c'est " + cheval.getNom() + " qui l'emporte à l'issue d'une course effrénée ! Bravo !");
        return  cheval;
    }
    
    public Course obtenirCourseParNom(String nomCourse) {
        Course course = courseDao.getCourseParNom(nomCourse);
        // Gestion des erreurs
        if (course == null) {
            System.out.println("La course n'existe pas");
            return null;
        }
        // -----------------------------------------
        return course;
    }

}
