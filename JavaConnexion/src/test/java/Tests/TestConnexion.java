package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.openjfx.javafx_archetype_simple.ConnexionController;
import org.openjfx.javafx_archetype_simple.JsonController;
import org.openjfx.javafx_archetype_simple.PrimaryController;


class TestConnexion {
	String path = "src/test/resources/json/personne.json";
	ConnexionController connexion = new ConnexionController();

    @BeforeClass
    public static void firstSetUp() {
        System.out.println("Début des tests de la classe ConnexionController.");
    }
    
    @Before
    public void setUp() throws Exception {
        this.connexion = new ConnexionController();
    }

    @After
    public void tearDown() throws Exception {
    	System.out.println("Fin du test");
        //this.connexion.shutdown();
    }

    @AfterClass
    public static void finalTearDown() throws Exception {
    	System.out.println("Fin des tests de la classe ConnexionController.");
        //this.connexion.shutdown();
    }
	
	/**
	 * Permet de vérifier que la connexion Admin est ok
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	public void testConnexionAdminOk() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		this.connexion.setId("blandine.danteuille");
		this.connexion.setMdp("azertyA");
		assertEquals("ADMIN", this.connexion.connexion());
	}
	
	/**
	 * Permet de vérifier que la connexion user est ok
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	public void testConnexionUserOk() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		this.connexion.setId("elias.jalal");
		this.connexion.setMdp("azertyU");
		assertEquals("USER", this.connexion.connexion());
	}
	
	/**
	 * Permet de simuler une connexion en erreur
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	public void testConnexionKO() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		this.connexion.setId("blandine.danteuille");
		this.connexion.setMdp("azertyU");
		assertEquals("NON", this.connexion.connexion());
	}
	
	/**
	 * Permet de vérifier que la connexion est not ok lorsque l'id est manquant
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	public void testConnexionVideId() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		this.connexion.setId("");
		this.connexion.setMdp("azertyU");
		assertEquals("NON", this.connexion.connexion());
	}
	
	/**
	 * Permet de vérifier que la connexion est not ok lorsque le mdp est manquant
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	public void testConnexionVideMdp() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		this.connexion.setId("blandine.danteuille");
		this.connexion.setMdp("");
		assertEquals("NON", this.connexion.connexion());
	}
	
	/**
	 * Permet de vérifier que la connexion est not ok lorsque l'id et le mdp sont manquants
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	public void testConnexionVide() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		this.connexion.setId("");
		this.connexion.setMdp("");
		assertEquals("NON", this.connexion.connexion());
	}
}
