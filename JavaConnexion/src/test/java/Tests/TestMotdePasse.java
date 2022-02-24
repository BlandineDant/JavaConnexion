package Tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.openjfx.javafx_archetype_simple.ConnexionController;
import org.openjfx.javafx_archetype_simple.JsonController;
import org.openjfx.javafx_archetype_simple.MdpOublieController;

public class TestMotdePasse {

	String path = "src/test/resources/json/personne.json";
	
	/**
	 * Permet de tester un cas succés dans le traitement permettant de générer un nouveau mdp
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testMDPAccesAutorise() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController oubliMDP = new ConnexionController("maneth.seng");
		assertEquals("ok",oubliMDP.motdepasse());
		String newmdp = oubliMDP.GeneratingRandomAlphanumericString();
		int i = oubliMDP.envoiIndex();
		String motdepasse=JsonController.personnes.get(i).getMdp();
		JsonController.personnes.get(i).setMdp(newmdp);
		JsonController.WriteJSON(path);
		assertNotEquals(motdepasse,JsonController.personnes.get(i).getMdp());
	}
	
	/**
	 * Permet de tester un cas erreur dans le traitement permettant de générer un nouveau mdp
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testMDPAccesNonAutorise() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController oubliMDP = new ConnexionController("maneth.se");
		assertEquals("NON",oubliMDP.motdepasse());
	}
}
