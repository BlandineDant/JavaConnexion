package org.openjfx.javafx_archetype_simple;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListeUsers {

	private String prenom;
	private String nom;
	private String role;
	private String date;
	private String adresse;
	private String email;
	private String telephone;
	
	/**
	 * Getter permettant de récupérer le prénom d'un utilisateur
	 * @return String prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * Setter permettant de modifier/ajouter le prénom d'un utilisateur
	 * @param String prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Getter permettant de récupérer le nom d'un utilisateur
	 * @return String nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Setter permettant de modifier/ajouter le nom d'un utilisateur
	 * @param String nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getter permettant de récupérer le rôle d'un utilisateur
	 * @return String role
	 */
	public String getRole() {
		return role;
	}
	
	/**
	 * Setter permettant de modifier/ajouter le rôle d'un utilisateur
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * Getter permettant de récupérer la date de naissance d'un utilisateur
	 * @return String date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * Setter permettant de modifier/ajouter la date de naissance d'un utilisateur
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	 * Getter permettant de récupérer l'adresse d'un utilisateur
	 * @return String adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	
	/**
	 * Setter permettant de modifier/ajouter l'adresse d'un utilisateur
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Getter permettant de récupérer l'email d'un utilisateur
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter permettant de modifier/ajouter l'email d'un utilisateur
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Getter permettant de récupérer le numéro de téléphone d'un utilisateur
	 * @return String telephone
	 */
	public String getTelephone() {
		return telephone;
	}
	
	/**
	 * Setter permettant de modifier/ajouter le numéro de téléphone d'un utilisateur
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	/**
	 * Permet de générer la liste des utilisateurs
	 * @param String prenom
	 * @param String nom
	 * @param String role
	 * @param String date
	 * @param String adresse
	 * @param String email
	 * @param String telephone
	 */
	public ListeUsers(String prenom, String nom, String role, String date, String adresse, String email, String telephone) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.role = role;
		this.date = date;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
	}
	
	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + "]";
	}
}
