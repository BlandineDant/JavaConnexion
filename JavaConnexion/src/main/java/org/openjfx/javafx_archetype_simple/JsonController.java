package org.openjfx.javafx_archetype_simple;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Model.Personne;


public class JsonController {
	
	public static List<Personne> personnes;
	
	public static void main(String[] args) throws org.json.simple.parser.ParseException, ParseException {
		
	}
	
	/**
	 * Permet de créer et d'écrire dans un fichier JSON
	 * @param path
	 */
	public static void WriteJSON(String path) 
	{
		/**
		 * Ajoute les personnes à la liste
		 */
	    JSONArray personneList = new JSONArray();
	        
		for (int i = 0; i < personnes.size(); i++) {
			String role = personnes.get(i).getRole();
			String nom = personnes.get(i).getNom();
			String prenom = personnes.get(i).getPrenom();
			String date = personnes.get(i).getDate();
			String adresse = personnes.get(i).getAdresse();
			String email = personnes.get(i).getEmail();
			String telephone = personnes.get(i).getTelephone();
			String photo = personnes.get(i).getPhoto();
			String login = personnes.get(i).getLogin();
			String mdp = personnes.get(i).getMdp();
			 
			//First Employee
		    JSONObject personneDetails = new JSONObject();
		    personneDetails.put("role", role);
		    personneDetails.put("nom", nom);
		    personneDetails.put("prenom", prenom);
		    personneDetails.put("date", date);
		    personneDetails.put("adresse", adresse);
		    personneDetails.put("email", email);
		    personneDetails.put("telephone", telephone);
		    personneDetails.put("photo", photo);
		    personneDetails.put("login", login);
		    personneDetails.put("mdp", mdp);
		        
		    JSONObject personneObject = new JSONObject(); 
		    personneObject.put("personne", personneDetails);
		    personneList.add(personneObject);       
		 }
		
	     /**
	      * On intègre la liste dans le JSON file
	      */
	     try (FileWriter file = new FileWriter(path)) {
	         file.write(personneList.toJSONString()); 
	         file.flush();
	     } catch (IOException e) {
	    	 e.printStackTrace();
	     }
	 }
	 
	/**
	 * Permet de lire le fichier JSON
	 * @param path
	 * @throws org.json.simple.parser.ParseException
	 * @throws ParseException
	 */
	 public static void ReadJSON(String path) throws org.json.simple.parser.ParseException, ParseException 
	 {
		 //JSON parser object to parse read file
	     JSONParser jsonParser = new JSONParser();
	     
	     try (FileReader reader = new FileReader(path))
	     {
	    	 //Read JSON file
	         Object obj = jsonParser.parse(reader);
	         JSONArray personneList = (JSONArray) obj;
	         personnes = new ArrayList<Personne>();
	            
	         //Iterate over employee array
	         personneList.forEach(pers -> parseEmployeeObject((JSONObject) pers ));
	 
	     } catch (FileNotFoundException e) {
	    	 e.printStackTrace();
	     } catch (IOException e) {
	    	 e.printStackTrace();
	     };		 
	 }
	 
	 /**
	  * Permet d'ajouter une nouvelle personne
	  * @param personne
	  */
	 private static void parseEmployeeObject(JSONObject personne) 
	 {
		 JSONObject personneObject = (JSONObject) personne.get("personne");
	         
	     String role = (String) personneObject.get("role");
	     String nom = (String) personneObject.get("nom");    
	     String prenom = (String) personneObject.get("prenom");    
	     String date = (String) personneObject.get("date");
	     String adresse = (String) personneObject.get("adresse");
	     String email = (String) personneObject.get("email");
	     String telephone = (String) personneObject.get("telephone");
	     String photo = (String) personneObject.get("photo");
	     String login = (String) personneObject.get("login");
	     String mdp = (String) personneObject.get("mdp");
	        
	     Personne user = new Personne(role,nom,prenom,date,adresse,email,telephone,photo,login,mdp);
	     personnes.add(user);
	 }
}
