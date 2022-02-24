package org.openjfx.javafx_archetype_simple;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class VerificationChamps {
	
	private static final String regex = "^(.+)@(.+)\\.(.+)$";
	public String role;
	public String nom;
	public String prenom;
	public String date;
	public String photo;
	public String adresse;
	public String telephone;
	public String email;
	
	/**
	 * Permet de récupérer le role attribué à une personne
	 * @return String role
	 */
	public String getRole() 
	{
		return role;
	}
	
	/**
	 * Permet de modifier/ajouter un role à une personne
	 * @param String role
	 */
	public void setRole(String role) 
	{
		this.role = role;
	}
	
	/**
	 * Permet de récupérer le nom d'une personne
	 * @return String nom
	 */
	public String getNom() 
	{
		return nom;
	}
	
	/**
	 * Permet de modifier/ajouter le nom d'une personne
	 * @param String nom
	 */
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	
	/**
	 * Permet de récupérer le prénom d'une personne
	 * @return String prenom
	 */
	public String getPrenom() 
	{
		return prenom;
	}
	
	/**
	 * Permet de modifier/ajouter le prenom d'une personne
	 * @param String prenom
	 */
	public void setPrenom(String prenom) 
	{
		this.prenom = prenom;
	}
	
	/**
	 * Permet de récupérer la date de naissance d'une personne
	 * @return String Date
	 */
	public String getDate() 
	{
		return date;
	}
	
	/**
	 * Permet de modifier/ajouter la date de naissance d'une personne
	 * @param String date
	 */
	public void setDate(String date) 
	{
		this.date = date;
	}
	
	/**
	 * Permet de récupérer la photo de profil d'une personne
	 * @return String photo
	 */
	public String getPhoto() 
	{
		return photo;
	}
	
	/**
	 * Permet de modifier/ajouter la photo de profil d'une personne
	 * @param String photo
	 */
	public void setPhoto(String photo) 
	{
		this.photo = photo;
	}
	
	/**
	 * Permet de récupérer l'adresse d'une personne
	 * @return String adresse
	 */
	public String getAdresse() 
	{
		return adresse;
	}
	
	/**
	 * Permet de modifier/ajouter l'adresse d'une personne
	 * @param String adresse
	 */
	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}
	
	/**
	 * Permet de récupérer le numéro de téléphone
	 * @return String telephone
	 */
	public String getTelephone() 
	{
		return telephone;
	}
	
	/**
	 * Permet de modifier/ajouter un numéro de téléphone
	 * @param String telephone
	 */
	public void setTelephone(String telephone) 
	{
		this.telephone = telephone;
	}
	
	/**
	 * Permet de récupérer l'email
	 * @return String email
	 */
	public String getEmail() 
	{
		return email;
	}
	
	/**
	 * Permet de modifier/ajouter un email
	 * @param String email
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	/**
	 * Permet de procéder à la vérification des champs du formulaire de connexion
	 * @param String role
	 * @param String nom
	 * @param String prenom
	 * @param String date
	 * @param String photo
	 * @param String adresse
	 * @param String telephone
	 * @param String email
	 */
	public VerificationChamps(String role, String nom, String prenom, String date, String photo, String adresse, String telephone, String email) 
	{
		super();
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.date = date;
		this.photo = photo;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}
	
	public VerificationChamps() 
	{
		super();
	}
	
	/**
	 * Permet de vérifier si les champs du formulaire de connexion sont vides
	 * @return int
	 */
	public int ChampsVide() 
	{
		
		if (role.isEmpty()==true || nom.isEmpty()==true ||prenom.isEmpty()==true || 
				date.isEmpty()==true || photo.isEmpty()==true || adresse.isEmpty()==true || 
				telephone.isEmpty()==true || email.isEmpty()==true) {
			return 0;
		} else {
			return 1;
		}
	}
	
	/**
	 * Permet de vérifier le format du numéro de téléphone
	 * @return int
	 */
	public int NumeroTelephone() 
	{
		try {
			int i = Integer.parseInt(telephone);
			char first = telephone.charAt(0);
			if (first =='0' && telephone.length()==10) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * Permet de vérifier le format de l'email
	 * @return int
	 */
	public int EmailFormat() 
	{
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches() == true) {
				return 1;
			} else {
				return 0;
			} 
		} catch (Exception e) {
			return 0;
		}
	}
}
