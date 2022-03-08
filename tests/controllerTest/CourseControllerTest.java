package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CourseController;
import model.Cheval;
import model.Course;
import model.Data;

import java.util.*;

class CourseControllerTest {
	
	CourseController coc;
	Date today;
	
	@BeforeEach
	void initTest() {
		today = new Date();
		coc = new CourseController();		
	}

	@Test
	void creerCourseTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		Data.setChevaux(chevaux);
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 1);
        
		assertTrue(coc.creerCourse("Prix du poulain d'or", c.getTime()));
	}

	@Test
	void creerCourseTestNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 1);
        
		assertFalse(coc.creerCourse("", c.getTime()));
	}

	@Test
	void creerCourseTestDateNull() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		Data.setChevaux(chevaux);
		assertFalse(coc.creerCourse("Prix du poulain d'or", null));
	}

	@Test
	void creerCourseTestDatePassee() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, -7);
		assertFalse(coc.creerCourse("Prix du poulain d'or", c.getTime()));
	}

	@Test
	void creerCourseTestListeChevauxIncorrect() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 1);
        
		assertFalse(coc.creerCourse("Prix du poulain d'or", c.getTime()));
	}

	@Test
	void supprimerCourseParNomTestOk() {
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
		assertTrue(coc.supprimerCourseParNom("Prix du poulain d'or"));
	}

	@Test
	void supprimerCourseParNomTestAvecNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("", new Date(), chevaux));
		courseList.add(new Course("Courses de l'hiver", new Date(), chevaux));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp", new Date(), chevaux));
		Data.setCourses(courseList);
		assertTrue(coc.supprimerCourseParNom(""));
	}

	@Test
	void supprimerCourseParNomTestNonExistante() {
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
		assertFalse(coc.supprimerCourseParNom("Le chouchou de la princesse"));
	}
	
	@Test
	void modifierCourseTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		Data.setChevaux(chevaux);
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 7);
		
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or", c.getTime(), chevaux));
		Data.setCourses(courseList);
		
		assertTrue(coc.modifierCourse("Prix du poulain d'or", "Prix de Marc", c.getTime()));
	}
	
	@Test
	void modifierCourseTestAvecNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 7);

		List<Course> courseList = new ArrayList();
		courseList.add(new Course("", c.getTime(), chevaux));
		Data.setCourses(courseList);
		assertFalse(coc.modifierCourse("", "Prix de Marc", c.getTime()));
	}
	
	@Test
	void modifierCourseTestAvecListeChevauxIncorrecte() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 7);

		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or", c.getTime(), chevaux));
		Data.setCourses(courseList);
		assertFalse(coc.modifierCourse("Prix du poulain d'or", "Prix de Marc", c.getTime()));
	}
	
	@Test
	void lancerCourseTestOK() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		chevaux.add(new Cheval("Bangali Boobli III", 25, 6));
		chevaux.add(new Cheval("Nico Nico Ni II", 38, 1));
		chevaux.add(new Cheval("Petite Fraise", 7, 5));
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 7);

		Course course = new Course("Prix du poulain d'or", c.getTime(), chevaux);
		
		assertNotNull(coc.lancerCourse(course));
	}

	@Test
	void lancerCourseTestQuandChevalToutSeul() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 7);

		Course course = new Course("Prix du poulain d'or", c.getTime(), chevaux);
		
		assertNull(coc.lancerCourse(course));
	}
	
	@Test
	void lancerCourseTestQuandPasCheval() {
		List<Cheval> chevaux = new ArrayList();
		
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DATE, 7);

		Course course = new Course("Prix du poulain d'or", c.getTime(), chevaux);
		
		assertNull(coc.lancerCourse(course));
	}
	
	@Test
	void obtenirCourseParNomTestOk() {
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
		
		assertNotNull(coc.obtenirCourseParNom("Prix du poulain d'or"));
	}
	
	@Test
	void obtenirCourseParNomTestAvecCourseNonExistante() {
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
		
		assertNull(coc.obtenirCourseParNom("Paris Dakar Canasson"));
	}
}
