package org.openjfx.javafx_archetype_simple;

import java.io.IOException;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class ConnexionController {

	public String id;
	public String mdp;
	protected static int indexpersonne;
	protected String role ;
	
    public ConnexionController(String id,String mdp) {
		// TODO Auto-generated constructor stub
    	this.id=id;
    	this.mdp=mdp;
	}
    
    public ConnexionController(String id) {
		// TODO Auto-generated constructor stub
    	this.id=id;
	}
    
	public ConnexionController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Getter permettant de récupérer le mdp
	 * @return mdp
	 */
	public String getMdp() {
		return mdp;
	}
	
	/**
	 * Setter permettant de modifier le mdp
	 * @param String mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	/**
	 * Getter permettant de récupérer l'identifiant
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter permettant de modifier l'identifiant
	 * @param String id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Permet de gérer le processus de connexion
	 * @return String autorisation
	 * @throws IOException
	 */
	public String connexion() throws IOException {
		Boolean connect= false;
		String autorisation ="NON";
		for (int i = 0; i < JsonController.personnes.size(); i++) {
		      if (id.equals(JsonController.personnes.get(i).getLogin())&&mdp.equals(JsonController.personnes.get(i).getMdp())) {
				indexpersonne=i;
				role=JsonController.personnes.get(i).getRole();
				connect=true;
		    	break;
		      }
		}
		
		if (connect==true) {
			
			if (role.equals("U")) {
				autorisation ="USER";
			} else if(role.equals("A")) {
				autorisation="ADMIN";
			}
		}
		return autorisation;
	}
	
	/**
	 * Permet de générer les alertes liées aux problèmes d'authentification 
	 */
	public void showAlertWithoutHeaderText() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Erreur authentification");
		alert.setHeaderText(null);
		alert.setContentText("Identifiant ou mot de passe incorrect.");
		alert.showAndWait();
	}
	
	/**
	 * Permet de gérer l'authentification par le mdp
	 * @return autorisation
	 * @throws IOException
	 */
	public String motdepasse() throws IOException {
		Boolean connect= false;
		String autorisation ="NON";
		for (int i = 0; i < JsonController.personnes.size(); i++) {
		      if (id.equals(JsonController.personnes.get(i).getLogin())) {
				indexpersonne=i;
				connect=true;
		    	  break;
		      }
		}

		if (connect==true) {
			autorisation="ok";
		}
		return autorisation;
	}
	
	/**
	 * Permet de générer un nouveau mot de passe
	 * @return String generatedString
	 */
	public String GeneratingRandomAlphanumericString() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}
	
	/**
	 * Permet de générer les alertes liées aux problèmes d'authentification
	 */
	public void showAlertWithoutHeaderTextMDP() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Erreur authentification");
		alert.setHeaderText(null);
		alert.setContentText("Identifiant incorrect.");
		alert.showAndWait();
	}
	
	/**
	 * Permet d'afficher le nouveau mdp dans une fenêtre pop-up
	 * @param String newmdp
	 */
	public void showAlertWithoutHeaderTextNewMDP(String newmdp) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Nouveau mot de passe");
		alert.setHeaderText(null);
		alert.setContentText("Votre nouveau mot de passe est : " + newmdp);
		alert.showAndWait();
	}

	@Override
	public String toString() {
		return "ConnexionController []";
	}
	
	/**
	 * Permet de renvoyer l'index d'une personne
	 * @return indexpersonne
	 */
	public static int envoiIndex() {
		return indexpersonne;
	}
}
