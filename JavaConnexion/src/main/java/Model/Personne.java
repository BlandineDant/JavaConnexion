package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Personne {

	private String prenom;
	private String nom;
	private String role;
	private String date;
	private String adresse;
	private String email;
	private String telephone;
	private String photo;
	private String login;
	private String mdp;
	
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Personne() {
		
	}
	public Personne(String role, String nom, String prenom,  String date, String adresse, String email, String telephone,
			String photo, String login, String mdp) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.role = role;
		this.date = date;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.photo = photo;
		this.login = login;
		this.mdp = mdp;
	}
	
	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", role=" + role + ", date=" + date + ", adresse="
				+ adresse + ", email=" + email + ", telephone=" + telephone + ", photo=" + photo + ", login=" + login
				+ ", mdp=" + mdp + "]";
	}
}
