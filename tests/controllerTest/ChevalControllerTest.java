package controllerTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.ChevalController;
import model.Cheval;
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
		assertFalse(chc.creerCheval("Rainbow Dash", -2));
	}

	@Test
	void creerChevalTestWhenAgeVieux() {
		assertFalse(chc.creerCheval("Rainbow Dash", 52));
	}

	@Test
	void creerChevalTestWhenAgeEgaleZero() {
		assertFalse(chc.creerCheval("Rainbow Dash", 0));
	}

	@Test
	void supprimerChevalParNomTest() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 0));
		chevaux.add(new Cheval("Petit Tonerre", 1, 3));
		chevaux.add(new Cheval("Jolly Jumper", 4, 4));
		Data.setChevaux(chevaux);
		assertTrue(chc.supprimerChevalParNom("Rainbow Dash"));
	}
	
	@Test
	void supprimerChevalParNomTestAvecNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 1, 2));
		chevaux.add(new Cheval("Petit Tonerre", 0, 1));
		chevaux.add(new Cheval("Jolly Jumper", 2, 4));
		Data.setChevaux(chevaux);
		assertFalse(chc.supprimerChevalParNom(""));
	}
	
	@Test
	void supprimerChevalParNomTestAvecNomNonExistant() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertFalse(chc.supprimerChevalParNom("Pinky"));
	}
	
	@Test
	void modifierChevalTest() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertTrue(chc.modifierCheval("Rainbow Dash", "Pinky", 2));
	}

	@Test
	void modifierChevalTestAvecNomVide() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertFalse(chc.modifierCheval("", "Pinky", 2));
	}

	@Test
	void modifierChevalTestAvecAgeSousZero() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertFalse(chc.modifierCheval("Rainbow Dash", "Pinky", -2));
	}

	@Test
	void modifierChevalTestAvecAgeVieux() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertFalse(chc.modifierCheval("Rainbow Dash", "Pinky", 52));
	}

	@Test
	void modifierChevalTestAvecChevalNonExistant() {
		List<Cheval> chevaux = new ArrayList();
		chevaux.add(new Cheval("Rainbow Dash", 2, 1));
		chevaux.add(new Cheval("Petit Tonerre", 2, 3));
		chevaux.add(new Cheval("Jolly Jumper", 5, 4));
		Data.setChevaux(chevaux);
		assertFalse(chc.modifierCheval("Petit Parfum", "Pinky", 52));
	}
	
	@Test
	void ajouterVictoireChevalTest() {
		Cheval c = new Cheval("Parfum Angelique", 22, 1);
		assertTrue(chc.ajouterVictoireCheval(c));
	}
}
