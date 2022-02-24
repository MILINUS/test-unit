package dao;

import java.util.Date;
import java.util.List;
import model.Cheval;
import model.Course;

public class CourseDao {

    public Course creerCourse(String nom, Date date, List<Cheval> chevaux) {
        return new Course(nom, date, chevaux);
    }

}
