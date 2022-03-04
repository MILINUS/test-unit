package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.CourseController;
import model.Cheval;
import model.Course;

import java.util.*;

class CoursesControllerTest {
	
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
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		chevaux.add(new Cheval("Bangali Boobli III"));
		chevaux.add(new Cheval("Nico Nico Ni II"));
		chevaux.add(new Cheval("Petite Fraise"));
		Data.setChevaux(chevaux);
		Date date = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		assertTrue(coc.creerCourse("Prix du poulain d'or", date));
	}

	@Test
	void creerCourseTestNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		chevaux.add(new Cheval("Bangali Boobli III"));
		chevaux.add(new Cheval("Nico Nico Ni II"));
		chevaux.add(new Cheval("Petite Fraise"));
		Data.setChevaux(chevaux);
		Date date = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		assertFalse(coc.creerCourse("", date));
	}

	@Test
	void creerCourseTestDateVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		chevaux.add(new Cheval("Bangali Boobli III"));
		chevaux.add(new Cheval("Nico Nico Ni II"));
		chevaux.add(new Cheval("Petite Fraise"));
		Data.setChevaux(chevaux);
		assertFalse(coc.creerCourse("Prix du poulain d'or", ""));
	}

	@Test
	void creerCourseTestDatePassee() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		chevaux.add(new Cheval("Bangali Boobli III"));
		chevaux.add(new Cheval("Nico Nico Ni II"));
		chevaux.add(new Cheval("Petite Fraise"));
		Data.setChevaux(chevaux);
		Date date = new Date(today.getTime() - (7 * (1000 * 60 * 60 * 24)));
		assertFalse(coc.creerCourse("Prix du poulain d'or", date));
	}

	@Test
	void creerCourseTestListeChevauxIncorrect() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Bangali Boobli III"));
		chevaux.add(new Cheval("Nico Nico Ni II"));
		chevaux.add(new Cheval("Petite Fraise"));
		Data.setChevaux(chevaux);
		Date date = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		assertFalse(coc.creerCourse("Prix du poulain d'or", date));
	}

	@Test
	void supprimerCourseParNomTestOk() {
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or"));
		courseList.add(new Course("Courses de l'hiver"));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp"));
		Data.setCourses(courseList);
		assertTrue(coc.supprimerCourseParNom("Prix du poulain d'or"));
	}

	@Test
	void supprimerCourseParNomTestAvecNomVide() {
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or"));
		courseList.add(new Course("Courses de l'hiver"));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp"));
		Data.setCourses(courseList);
		assertTrue(coc.supprimerCourseParNom(""));
	}

	@Test
	void supprimerCourseParNomTestNonExistante() {
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or"));
		courseList.add(new Course("Courses de l'hiver"));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp"));
		Data.setCourses(courseList);
		assertTrue(coc.supprimerCourseParNom("Le chouchou de la princesse"));
	}
	
	@Test
	void modifierCourseTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		chevaux.add(new Cheval("Bangali Boobli III"));
		chevaux.add(new Cheval("Nico Nico Ni II"));
		chevaux.add(new Cheval("Petite Fraise"));
		Data.setChevaux(chevaux);
		Date date = new Date(today.getTime() + (7 * (1000 * 60 * 60 * 24)));
		assertTrue(coc.modifierCourse("Prix du poulain d'or", "Prix de Marc", date));
	}
	
	@Test
	void modifierCourseTestAvecNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		chevaux.add(new Cheval("Bangali Boobli III"));
		chevaux.add(new Cheval("Nico Nico Ni II"));
		chevaux.add(new Cheval("Petite Fraise"));
		Data.setChevaux(chevaux);
		Date date = new Date(today.getTime() + (7 * (1000 * 60 * 60 * 24)));
		assertTrue(coc.modifierCourse("", "Prix de Marc", date));
	}
	
	@Test
	void modifierCourseTestAvecListeChevauxIncorrecte() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		Date date = new Date(today.getTime() + (7 * (1000 * 60 * 60 * 24)));
		assertTrue(coc.modifierCourse("Prix du poulain d'or", "Prix de Marc", date));
	}
}
