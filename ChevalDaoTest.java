package daoTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.ChevalDao;
import dao.CourseDao;
import model.Course;
import model.Cheval;

class ChevalDaoTest {

	ChevalDao chDao;
	
	@BeforeEach
	void initTest() {
		chDao = new ChevalDao();
	}
	
	@Test
	void creerChevalTestOk() {
		assertTrue(chDao.creerCheval("Territory Mateo III", 12, 1));
	}
	
	@Test
	void obtenirChevalTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertNotNull(chDao.obtenirCourses());
	}

	@Test
	void obtenirChevalTestKO() {
		assertNull(chDao.obtenirCheval());
	}
	
	@Test
	void getChevalParNomTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertNotNull(chDao.getChevalParNom("Petit Tonerre"));
	}

	@Test
	void getChevalParNomTestKO() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertNotNull(chDao.getChevalParNom("Petit Anthony"));
	}

	@Test
	void supprimerChevalTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		
		Cheval c = new Cheval("Rainbow Dash");
		assertTrue(chDao.supprimerCheval(c));
	}

	@Test
	void supprimerCourseTestKO() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		
		Cheval c = new Cheval("Yuki ± Yuno");
		assertTrue(chDao.supprimerCheval(c));
	}

	
}
