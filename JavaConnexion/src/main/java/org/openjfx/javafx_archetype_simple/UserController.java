package org.openjfx.javafx_archetype_simple;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class UserController {
	
	  @FXML
	    private Label lblNom;
	  @FXML
	  	private Label lblPrenom;
	  @FXML
	    private Label lblDate;
	  @FXML
	  	private Label lblAdresse;
	  @FXML
	    private Label lblEmail;
	  @FXML
	  	private Label lblTelephone;
	  @FXML
		public ImageView imageviewPhoto;
	  @FXML
		public ImageView imageviewDessin;
	  
	  
	  private void init() {
		  
		  File file1 = new File("src/main/resources/images/identity.png");
		  
	    	 Image image1 = new Image(file1.toURI().toString(), 77, 77, false, false);
	    	 imageviewDessin.setFitHeight(77);
	    	 imageviewDessin.setFitWidth(77);
	    	 imageviewDessin.setImage(image1);
	    	 
		  ConnexionController index= new ConnexionController();
		  int i=index.envoiIndex();
		  String nom = JsonController.personnes.get(i).getNom();
		  nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
		  String prenom = JsonController.personnes.get(i).getPrenom();
		  prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
		  
		  try {
			  Image image = new Image(JsonController.personnes.get(i).getPhoto(), 165, 208, false, false);
		       imageviewPhoto.setFitHeight(208);
		       imageviewPhoto.setFitWidth(165);
		       imageviewPhoto.setImage(image);
		  }
		  catch(Exception e) {
			  File file = new File("src/main/resources/images/user.png");
			  Image image = new Image(file.toURI().toString(), 165, 208, false, false);
		       imageviewPhoto.setFitHeight(208);
		       imageviewPhoto.setFitWidth(165);
		       imageviewPhoto.setImage(image);
		  }

	        lblNom.setText(nom);
	        lblPrenom.setText(prenom);
	        lblDate.setText(JsonController.personnes.get(i).getDate());
	        lblAdresse.setText(JsonController.personnes.get(i).getAdresse());
	        lblEmail.setText(JsonController.personnes.get(i).getEmail());
	        lblTelephone.setText(JsonController.personnes.get(i).getTelephone());
	        
	    }

	    @FXML
	    private void initialize() {
	    	init();
	    }
	    
	    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
  
}
