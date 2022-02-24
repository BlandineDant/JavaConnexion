package org.openjfx.javafx_archetype_simple;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MdpOublieController {
	
	@FXML
	public TextField textfieldMDP;
	
	@FXML
	public ImageView imageviewDessin;
	
	String path = "src/main/resources/json/personne.json";
	
	@FXML
	private void initialize() {
		File file = new File("src/main/resources/images/motdepasse.png");
    	Image image = new Image(file.toURI().toString(), 77, 77, false, false);
    	imageviewDessin.setFitHeight(77);
    	imageviewDessin.setFitWidth(77);
    	imageviewDessin.setImage(image);
	}
	
	/**
	 * Permet de gérer la génération d'un nouveau mdp
	 * @throws IOException
	 */
	@FXML
    private void motdepasse() throws IOException {
		ConnexionController oubliMDP = new ConnexionController(textfieldMDP.getText());
		String autorisation = oubliMDP.motdepasse();
		if (autorisation=="ok") {
			String newmdp = oubliMDP.GeneratingRandomAlphanumericString();
			int i = oubliMDP.indexpersonne;
			JsonController.personnes.get(i).setMdp(newmdp);
			oubliMDP.showAlertWithoutHeaderTextNewMDP(newmdp);
			JsonController.WriteJSON(path);
		} else {
			oubliMDP.showAlertWithoutHeaderTextMDP();
		}
    }
	 
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
