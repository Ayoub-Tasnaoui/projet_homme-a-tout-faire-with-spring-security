package com.example.demo.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bricoleur   {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String password;
	private String nom;
	private String prenom;
	private String ville;
	private String num;
	
	

	@OneToMany(mappedBy = "bricoleur")
	private List<ServiceBrico> service;

	

	public Bricoleur() {
		// TODO Auto-generated constructor stub
	}

	








	public Bricoleur(int id, String userName, String password, String nom, String prenom, String ville, String num,
			List<ServiceBrico> service) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.num = num;
		this.service = service;
	}










	public int getId() {
		return id;
	}






	public void setId(int id) {
		this.id = id;
	}






	public String getUserName() {
		return userName;
	}






	public void setUserName(String userName) {
		this.userName = userName;
	}






	public String getPassword() {
		return password;
	}






	public void setPassword(String password) {
		this.password = password;
	}






	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<ServiceBrico> getService() {
		return service;
	}

	public void setService(List<ServiceBrico> service) {
		this.service = service;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}






	@Override
	public String toString() {
		return "Bricoleur [id=" + id + ", userName=" + userName + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + ", ville=" + ville + ", num=" + num + ", service=" + service + "]";
	}
	
	

	

	
	
	
	

}
