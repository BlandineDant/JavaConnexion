package Tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.openjfx.javafx_archetype_simple.ConnexionController;
import org.openjfx.javafx_archetype_simple.JsonController;

public class TestUser {

	String path = "src/test/resources/json/personne.json";
	
	/**
	 * Permet de tester la bonne récupération des infos d'un profil user
	 * @throws ParseException
	 * @throws java.text.ParseException
	 * @throws IOException
	 */
	@Test
	void testUser() throws ParseException, java.text.ParseException, IOException {
		JsonController.ReadJSON(path);
		ConnexionController connexion = new ConnexionController();
		connexion.setId("elias.jalal");
		connexion.setMdp("azertyU");
		connexion.connexion();
		ConnexionController index= new ConnexionController();
		int i=index.envoiIndex();

		assertEquals("U",JsonController.personnes.get(i).getRole());
		assertEquals("jalal",JsonController.personnes.get(i).getNom());
		assertEquals("elias",JsonController.personnes.get(i).getPrenom());
		assertEquals("11-10-1996",JsonController.personnes.get(i).getDate());
		assertEquals("14 rue Robert Capa",JsonController.personnes.get(i).getAdresse());
		assertEquals("elias.j@orange.fr",JsonController.personnes.get(i).getEmail());
		assertEquals("https://static.wikia.nocookie.net/lemondededisney/images/9/9d/Mushu-pesonnage-mulan-06.jpg/revision/latest/top-crop/width/360/height/450?cb=20190531091121&path-prefix=fr",JsonController.personnes.get(i).getPhoto());
		assertEquals("0123456787",JsonController.personnes.get(i).getTelephone());
	}
}
