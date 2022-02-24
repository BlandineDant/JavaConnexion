package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.openjfx.javafx_archetype_simple.ConnexionController;
import org.openjfx.javafx_archetype_simple.JsonController;
import org.openjfx.javafx_archetype_simple.PrimaryController;


class TestConnexion {
	String path = "src/test/resources/json/personne.json";
	
	/**
	 * Permet de vérifier que la connexion Admin est ok
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testConnexionAdminOk() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController connexion = new ConnexionController();
		connexion.setId("blandine.danteuille");
		connexion.setMdp("azertyA");
		assertEquals("ADMIN",connexion.connexion());
	}
	
	/**
	 * Permet de vérifier que la connexion user est ok
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testConnexionUserOk() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController connexion = new ConnexionController();
		connexion.setId("elias.jalal");
		connexion.setMdp("azertyU");
		assertEquals("USER",connexion.connexion());
	}
	
	/**
	 * Permet de simuler une connexion en erreur
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testConnexionKO() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController connexion = new ConnexionController();
		connexion.setId("blandine.danteuille");
		connexion.setMdp("azertyU");
		assertEquals("NON",connexion.connexion());
	}
	
	/**
	 * Permet de vérifier que la connexion est not ok lorsque l'id est manquant
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testConnexionVideId() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController connexion = new ConnexionController();
		connexion.setId("");
		connexion.setMdp("azertyU");
		assertEquals("NON",connexion.connexion());
	}
	
	/**
	 * Permet de vérifier que la connexion est not ok lorsque le mdp est manquant
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testConnexionVideMdp() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController connexion = new ConnexionController();
		connexion.setId("blandine.danteuille");
		connexion.setMdp("");
		assertEquals("NON",connexion.connexion());
	}
	
	/**
	 * Permet de vérifier que la connexion est not ok lorsque l'id et le mdp sont manquants
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testConnexionVide() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController connexion = new ConnexionController();
		connexion.setId("");
		connexion.setMdp("");
		assertEquals("NON",connexion.connexion());
	}
}
