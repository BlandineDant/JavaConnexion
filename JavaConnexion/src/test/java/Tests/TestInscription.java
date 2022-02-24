package Tests;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Model.Personne;


public class TestInscription {

	@Test
	public void testConstructeur() {
		char role = 'u';
		String photo = "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/User_icon-cp.svg/1200px-User_icon-cp.svg.png";
		String prenom = "prenom";
		String nom = "nom";
		String mail = "mail@orange.fr";
		int tel = 0000000000;
		String adresse = "10 rue XXX";
		Date datenaissance = new Date();
	}

}
