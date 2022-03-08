package daoTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.CourseDao;
import model.Cheval;
import model.Course;
import model.Data;;

class CourseDaoTest {

	CourseDao cDao;
	
	@BeforeEach
	void initTest() {
		cDao = new CourseDao();
	}
	
	@Test
	void creerCourseTestOk() {
		assertTrue(cDao.creerCourse(new Course("Paris Dakar", new Date(), new ArrayList<Cheval>())));
	}
	
	@Test
	void obtenirCoursesTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or", new Date(), chevaux));
		courseList.add(new Course("Courses de l'hiver", new Date(), chevaux));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp", new Date(), chevaux));
		Data.setCourses(courseList);
		assertNotNull(cDao.obtenirCourses());
	}

	@Test
	void obtenirCoursesTestQuandPasCourse() {
		assertNotNull(cDao.obtenirCourses());
	}
	
	@Test
	void getCourseParNomTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or", new Date(), chevaux));
		courseList.add(new Course("Courses de l'hiver", new Date(), chevaux));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp", new Date(), chevaux));
		Data.setCourses(courseList);
		assertNotNull(cDao.getCourseParNom("Prix du poulain d'or"));
	}

	@Test
	void getCourseParNomTestKO() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or", new Date(), chevaux));
		courseList.add(new Course("Courses de l'hiver", new Date(), chevaux));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp", new Date(), chevaux));
		Data.setCourses(courseList);
		assertNull(cDao.getCourseParNom("Paris Dakar"));
	}

	@Test
	void supprimerCourseTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or", new Date(), chevaux));
		courseList.add(new Course("Courses de l'hiver", new Date(), chevaux));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp", new Date(), chevaux));
		Data.setCourses(courseList);
		
		assertTrue(cDao.supprimerCourse(courseList.get(0)));
	}

	@Test
	void supprimerCourseTestKO() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or", new Date(), chevaux));
		courseList.add(new Course("Courses de l'hiver", new Date(), chevaux));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp", new Date(), chevaux));
		Data.setCourses(courseList);
		
		Course c = new Course("Paris Dakar", new Date(), chevaux);
		assertFalse(cDao.supprimerCourse(c));
	}

}
