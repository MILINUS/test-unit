package daoTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.ChevalDao;
import dao.CourseDao;
import model.Course;
import model.Data;
import model.Cheval;

class ChevalDaoTest {

	ChevalDao chDao;
	
	@BeforeEach
	void initTest() {
		chDao = new ChevalDao();
	}
	
	@Test
	void creerChevalTestOk() {
		assertTrue(chDao.creerCheval(new Cheval("Territory Mateo III", 12, 1)));
	}
	
	@Test
	void obtenirChevalTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertNotNull(chDao.obtenirCheval());
	}

	@Test
	void obtenirChevalTestQaundPasCheval() {
		assertNotNull(chDao.obtenirCheval());
	}
	
	@Test
	void getChevalParNomTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertNotNull(chDao.getChevalParNom("Petit Tonerre"));
	}

	@Test
	void getChevalParNomTestKO() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertNull(chDao.getChevalParNom("Petit Anthony"));
	}

	@Test
	void supprimerChevalTestOk() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		
		assertTrue(chDao.supprimerCheval(chevaux.get(0)));
	}

	@Test
	void supprimerChevalTestWhenAgeNonCorrespondant() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		
		Cheval c = new Cheval("Rainbow Dash", 10, 1);
		assertFalse(chDao.supprimerCheval(c));
	}

	@Test
	void supprimerCourseTestChevalNonExiste() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		
		Cheval c = new Cheval("Yuki ± Yuno", 4, 1);
		assertFalse(chDao.supprimerCheval(c));
	}

}
