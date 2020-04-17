package com.example.demo.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Bricoleur extends User  {

	
	private String nom;
	private String prenom;
	private String ville;
	private String num;
	
	

	@OneToMany(mappedBy = "bricoleur")
	private List<ServiceBrico> service;

	

	public Bricoleur() {
		// TODO Auto-generated constructor stub
	}

	public Bricoleur(String userName, String password, String nom, String prenom, String ville, String num) {
		super(userName, password);
		
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.num = num;
		
	}
	public Bricoleur( String nom, String prenom, String ville, String num) {
		
		
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.num = num;
		
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
		return "Bricoleur [nom=" + nom + ", prenom=" + prenom + ", ville=" + ville + ", num=" + num + ", service="
				+ service + "]";
	}

	
	
	
	

}
