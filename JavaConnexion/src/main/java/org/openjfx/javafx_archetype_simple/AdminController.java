package org.openjfx.javafx_archetype_simple;

import java.io.File;
import java.io.IOException;
import java.util.List;

import Model.Personne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AdminController {

	@FXML
    private TableView<ListeUsers> listeUsers;
 	@FXML
    public TableColumn<ListeUsers, String> roleuser;
	@FXML
    public TableColumn<ListeUsers, String> nomuser;
	@FXML
    public TableColumn<ListeUsers, String> prenomuser;
	@FXML
    public TableColumn<ListeUsers, String> dateuser;
	@FXML
    public TableColumn<ListeUsers, String> adresseuser;
	@FXML
    public TableColumn<ListeUsers, String> emailuser;
	@FXML
    public TableColumn<ListeUsers, String> telephoneuser;
	  @FXML
		public ImageView imageviewDessin;
	

	    
	  ObservableList<ListeUsers> getUsersList(){
	    	ObservableList<ListeUsers> personnes = FXCollections.observableArrayList();
	    	  
	    	 	for (int i = 0; i < JsonController.personnes.size(); i++) {
		    	  String nom = JsonController.personnes.get(i).getNom();
				  String prenom = JsonController.personnes.get(i).getPrenom();
				  String role = JsonController.personnes.get(i).getRole();
				  String date = JsonController.personnes.get(i).getDate();
				  String adresse = JsonController.personnes.get(i).getAdresse();
				  String email = JsonController.personnes.get(i).getEmail();
				  String telephone = JsonController.personnes.get(i).getTelephone();
				  nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
				  prenom = prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
				  role = role.substring(0, 1).toUpperCase() + role.substring(1);

				  personnes.add(new ListeUsers(prenom,nom,role,date,adresse,email,telephone));
			  }
			  return personnes;
	    	
	    }
	    
	  private void init() {
		  roleuser.setCellValueFactory(new PropertyValueFactory<>("role"));
		  nomuser.setCellValueFactory(new PropertyValueFactory<>("nom"));
		  prenomuser.setCellValueFactory(new PropertyValueFactory<>("prenom"));
		  dateuser.setCellValueFactory(new PropertyValueFactory<>("date"));
		  adresseuser.setCellValueFactory(new PropertyValueFactory<>("adresse"));
		  emailuser.setCellValueFactory(new PropertyValueFactory<>("email"));
		  telephoneuser.setCellValueFactory(new PropertyValueFactory<>("telephone"));
		  listeUsers.setItems(getUsersList());
		  
		  File file = new File("src/main/resources/images/admin.png");
	    	 Image image = new Image(file.toURI().toString(), 77, 77, false, false);
	    	 imageviewDessin.setFitHeight(77);
	    	 imageviewDessin.setFitWidth(77);
	    	 imageviewDessin.setImage(image);
		  
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
