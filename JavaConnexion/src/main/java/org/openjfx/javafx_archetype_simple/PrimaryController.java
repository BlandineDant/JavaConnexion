package org.openjfx.javafx_archetype_simple;

import java.io.File;
import java.io.IOException;

import Model.Personne;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PrimaryController {
	
	@FXML
	public TextField textfieldID;

	@FXML
	private PasswordField passwordfieldMDP;
	
	@FXML
	public ImageView imageviewDessin;
	
	@FXML
	private void initialize() {
		File file = new File("src/main/resources/images/key.png");
		Image image = new Image(file.toURI().toString(), 77, 77, false, false);
		imageviewDessin.setFitHeight(77);
		imageviewDessin.setFitWidth(77);
		imageviewDessin.setImage(image);
	}
	
	/**
	 * Permet de gérer le système de connexion
	 * @throws IOException
	 */
	@FXML
	private void connexion() throws IOException {
		ConnexionController identification = new ConnexionController(textfieldID.getText(),passwordfieldMDP.getText());
		String connexion = identification.connexion();	
		if (connexion=="USER") {
			App.setRoot("connexionuser");
		} else if (connexion=="ADMIN") {
			App.setRoot("connexionadmin");
		} else {
			identification.showAlertWithoutHeaderText();
		}
	}
	
	/**
	 * Permet de rejoindre l'ihm inscription
	 * @throws IOException
	 */
    @FXML
    private void switchToInscription() throws IOException {
        App.setRoot("inscription");
    }
    
    /**
     * Permet de rejoindre l'ihm de connexion admin
     * @throws IOException
     */
    @FXML
    private void switchToAdmin() throws IOException {
        App.setRoot("connexionadmin");
    }
    
    /**
     * Permet de rejoindre l'ihm du mdp oublié
     * @throws IOException
     */
    @FXML
    private void switchToMdp() throws IOException {
        App.setRoot("mdpoublie");
    }
}
