package org.openjfx.javafx_archetype_simple;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

import Model.Personne;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InscriptionController {
	
	@FXML
	public ChoiceBox choiceRole = new ChoiceBox();
	@FXML
	public TextField textfieldNom;
	@FXML
	public TextField textfieldPrenom;
	@FXML
	public DatePicker dateNaissance;
	@FXML
	public TextField textfieldPhoto;
	@FXML
	public ImageView imageviewPhoto;
	@FXML
	public TextField textfieldAdresse;
	@FXML
	public TextField textfieldTelephone;
	@FXML
	public TextField textfieldEmail;
	  @FXML
		public ImageView imageviewDessin;
	
	String path ="src/main/resources/json/personne.json";

    private DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");

    ConnexionController connexion = new ConnexionController();
	 
	 @FXML
	    private void initialize() {
		 
		 
		 choiceRole.getItems().add("Admin");
		 choiceRole.getItems().add("User");
		 
		 
		 
	    }
	 
	 	
	 @FXML
	    private void photo() throws IOException, ParseException {
		  String url = textfieldPhoto.getText();
		 
		 try {
	        Image image = new Image(url, 165, 208, false, false);
	        imageviewPhoto.setFitHeight(208);
	        imageviewPhoto.setFitWidth(165);
	        imageviewPhoto.setImage(image);
	        
	        }
		 catch (Exception e){
			 showAlert("Erreur de saisie","Une erreur s'est produite lors de l'ajout de la photo, le lien n'est pas valide.");
		 }
		 	
		 	
				
	    }
	 
	 @FXML
	    private void valider() throws IOException {
		 
		 try {
			 
			 String role = choiceRole.getValue().toString();
			 String nom = textfieldNom.getText();
			 String prenom = textfieldPrenom.getText();
			 String date = dateNaissance.getValue().toString();
			 String photo = textfieldPhoto.getText();
			 String adresse = textfieldAdresse.getText();
			 String telephone = textfieldTelephone.getText();
			 String email = textfieldEmail.getText();
			 
			 VerificationChamps verification = new VerificationChamps(role,nom,prenom,date,photo,adresse,telephone,email);
			 
			 int vide= verification.ChampsVide();

			 
			 if (vide == 0) {
				 
				 int phone=verification.NumeroTelephone();
				 if (phone==1) {
					int mail= verification.EmailFormat();
					
					if (mail==1) {						 
						 try {
					        Image image = new Image(photo, 165, 208, false, false);
					        imageviewPhoto.setFitHeight(208);
					        imageviewPhoto.setFitWidth(165);
					        imageviewPhoto.setImage(image);

					        showConfirm();
					        }
						 catch (Exception e){
							 showAlert("Erreur de saisie","Une erreur s'est produite lors de l'ajout de la photo, le lien n'est pas valide.");
						 }
					}
					else {
						showAlert("Erreur de saisie","Email invalide.");
					}
					
					
				 }
				 else {
					 showAlert("Erreur de saisie","Numéro de téléphone invalide.");
				 }
				 
			 }
			 else {
				 
				 showAlert("Erreur de saisie","Tous les champs doivent être remplis.");
			 }	 
		 }
		 catch (Exception e){
			 showAlert("Erreur de saisie","Erreur lors de la saisie. Vérifiez que tous les champs sont remplis correctement.");
			 } 
				
	    }
	 
	
	 	 
	 private void showConfirm() throws ParseException, IOException {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Valider l'inscription");

			// Header Text: null
			alert.setHeaderText(null);
			alert.setContentText("Valider votre inscription ?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				
				final String OLD_FORMAT = "yyyy-MM-dd";
				final String NEW_FORMAT = "dd-MM-yyyy";
				 
				 String role = choiceRole.getValue().toString();
				 String nom = textfieldNom.getText();
				 nom =nom.toLowerCase();
				 String prenom = textfieldPrenom.getText();
				 prenom = prenom.toLowerCase();
				 String date = dateNaissance.getValue().toString();
				 String photo = textfieldPhoto.getText();
				 String adresse = textfieldAdresse.getText();
				 String telephone = textfieldTelephone.getText();
				 String email = textfieldEmail.getText();
	 
				 String oldDateString = date;
				 String newDateString;
				 
				 SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
				 Date d = sdf.parse(oldDateString);
				 sdf.applyPattern(NEW_FORMAT);
				 newDateString = sdf.format(d);
				 date=newDateString;
				 
				 if (role=="Admin") {
					 role ="A";
				 }
				 else {
					 role ="U";
				 }
			 
				 String login= prenom+"."+nom;				 
				 String connect="";
				 String mdp = connexion.GeneratingRandomAlphanumericString();
				 
					for (int i = 0; i < JsonController.personnes.size(); i++) {
					      if (login.equals(JsonController.personnes.get(i).getLogin())) {
							connect="exist";
					    	  break;
					      }
					    }

					if (connect=="exist") {
						showAlert("Déjà inscrit","Vous êtes déjà inscrit.");
					}
					else {
				        Personne user = new Personne(role,nom,prenom,date,adresse,email,telephone,photo,login,mdp);
				        JsonController.personnes.add(user);
				        showAlertWithoutHeaderTextNewMDP(mdp);
						JsonController.WriteJSON(path);
						showConfirmInscription();
						switchToPrimary();
					}
			}
		}
	 
	
	
	 
	 private void showAlertWithoutHeaderTextNewMDP(String newmdp) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Nouveau mot de passe");

			// Header Text: null
			alert.setHeaderText(null);
			alert.setContentText("Votre nouveau mot de passe est : " + newmdp);

			alert.showAndWait();
		}
	 
	 private void showConfirmInscription() {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");

			// Header Text: null
			alert.setHeaderText(null);
			alert.setContentText("Votre inscription est confirmé.");

			alert.showAndWait();
		}
	 
	 private void showAlert(String titre, String message) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(titre);

			// Header Text: null
			alert.setHeaderText(null);
			alert.setContentText(message);

			alert.showAndWait();
		}
	 
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}