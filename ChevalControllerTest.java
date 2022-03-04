package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.ChevalController;
import model.Data;

class ChevalControllerTest {

	ChevalController chc;
	@BeforeEach
	void initTest() {
		chc = new ChevalController();
	}
	
	@Test
	void creerChevalTestOk() {
		assertTrue(chc.creerCheval("Rainbow Dash", 2));
	}
	
	@Test
	void creerChevalTestWhenNomVide() {
		assertFalse(chc.creerCheval("", 2));
	}

	@Test
	void creerChevalTestWhenAgeSousZero() {
		assertTrue(chc.creerCheval("Rainbow Dash", -2));
	}

	@Test
	void creerChevalTestWhenAgeVieux() {
		assertTrue(chc.creerCheval("Rainbow Dash", 52));
	}

	@Test
	void creerChevalTestWhenAgeEgaleZero() {
		assertTrue(chc.creerCheval("Rainbow Dash", 0));
	}

	@Test
	void supprimerChevalParNomTest() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertTrue(chc.supprimerChevalParNom("Rainbow Dash"));
	}
	
	@Test
	void supprimerChevalParNomTestAvecNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertFalse(chc.supprimerChevalParNom(""));
	}
	
	@Test
	void supprimerChevalParNomTestAvecNomNonExistant() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertFalse(chc.supprimerChevalParNom("Pinky"));
	}
	
	@Test
	void modifierChevalTest() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertTrue(chc.modifierCheval("Rainbow Dash", "Pinky", 2));
	}

	@Test
	void modifierChevalTestAvecNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertFalse(chc.modifierCheval("", "Pinky", 2));
	}

	@Test
	void modifierChevalTestAvecAgeSousZero() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertFalse(chc.modifierCheval("Rainbow Dash", "Pinky", -2));
	}

	@Test
	void modifierChevalTestAvecAgeVieux() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertFalse(chc.modifierCheval("Rainbow Dash", "Pinky", 52));
	}

	@Test
	void modifierChevalTestAvecChevalNonExistant() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash"));
		chevaux.add(new Cheval("Petit Tonerre"));
		chevaux.add(new Cheval("Jolly Jumper"));
		Data.setChevaux(chevaux);
		assertFalse(chc.modifierCheval("Petit Parfum", "Pinky", 52));
	}
}
