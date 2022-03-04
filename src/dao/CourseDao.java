package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Course;
import model.Data;

public class CourseDao {
    
    public CourseDao() {
        Data.setCourses(new ArrayList<Course>());
    }

    public boolean creerCourse(Course course) {
        return Data.getCourses().add(course);
    }
    
    public List<Course> obtenirCourses() {
        return Data.getCourses();
    }
    
    public Course getCourseParNom(String nomCourse) {
        Course course = null;
        for (Course c : obtenirCourses()) {
            if (c.getNom().equals(nomCourse)) {
                course = c;
            }
        }
        return course;
    }
    
    public boolean supprimerCourse(Course course) {
        return Data.getCourses().remove(course);
    }
    
    public boolean modifierCourse(Course course, String nouveauNomCourse, Date nouvelleDateCourse) {
        course.setNom(nouveauNomCourse);
        course.setDate(nouvelleDateCourse);
        return true;
    }
    
}
