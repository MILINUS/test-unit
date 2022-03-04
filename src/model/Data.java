/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author hugoc
 */
public class Data {
    
    static List<Course> courses;
    static List<Cheval> chevaux;

    public static List<Course> getCourses() {
        return courses;
    }

    public static void setCourses(List<Course> courses) {
        Data.courses = courses;
    }

    public static List<Cheval> getChevaux() {
        return chevaux;
    }

    public static void setChevaux(List<Cheval> chevaux) {
        Data.chevaux = chevaux;
    }
    
}
