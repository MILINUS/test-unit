package daoTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.CourseDao;
import model.Cheval;
import model.Course;;

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
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or"));
		courseList.add(new Course("Courses de l'hiver"));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp"));
		Data.setCourses(courseList);
		assertNotNull(cDao.obtenirCourses());
	}

	@Test
	void obtenirCoursesTestKO() {
		assertNull(cDao.obtenirCourses());
	}
	
	@Test
	void getCourseParNomTestOk() {
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or"));
		courseList.add(new Course("Courses de l'hiver"));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp"));
		Data.setCourses(courseList);
		assertNotNull(cDao.getCourseParNom("Prix du poulain d'or"));
	}

	@Test
	void getCourseParNomTestKO() {
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or"));
		courseList.add(new Course("Courses de l'hiver"));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp"));
		Data.setCourses(courseList);
		assertNull(cDao.getCourseParNom("Paris Dakar"));
	}

	@Test
	void supprimerCourseTestOk() {
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or"));
		courseList.add(new Course("Courses de l'hiver"));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp"));
		Data.setCourses(courseList);
		
		Course c = new Course("Prix du poulain d'or");
		assertTrue(cDao.supprimerCourse(c));
	}

	@Test
	void supprimerCourseTestKO() {
		List<Course> courseList = new ArrayList();
		courseList.add(new Course("Prix du poulain d'or"));
		courseList.add(new Course("Courses de l'hiver"));
		courseList.add(new Course("Grand Prix de l'hippodrome de Longchamp"));
		Data.setCourses(courseList);
		
		Course c = new Course("Paris Dakar");
		assertFalse(cDao.supprimerCourse(c));
	}

}
