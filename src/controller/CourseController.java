package controller;

import dao.CourseDao;
import java.util.Date;
import java.util.List;
import model.Cheval;
import model.Course;

public class CourseController {

    CourseDao courseDao;

    public Course creerCourse(String nom, Date date, List<Cheval> chevaux) {
        if (nom == null || date == null || chevaux == null || chevaux.size() != 6) {
            return null;
        }
        return courseDao.creerCourse(nom, date, chevaux);
    }
}
