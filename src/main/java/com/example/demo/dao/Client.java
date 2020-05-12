package com.example.demo.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nom;
	private String prenom;
	private String ville;
	private String num;

	@OneToMany(mappedBy = "client")
	private List<BesoinClient> besoinClient;

	public Client() {
		super();
	}

	
	
	 
    
	

	

	public Client(int id, String nom, String prenom, String ville, String num, List<BesoinClient> besoinClient) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.ville = ville;
		this.num = num;
		this.besoinClient = besoinClient;
	}









	public int getId() {
		return id;
	}









	public void setId(int id) {
		this.id = id;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public List<BesoinClient> getBesoinClient() {
		return besoinClient;
	}

	public void setBesoinClient(List<BesoinClient> besoinClient) {
		this.besoinClient = besoinClient;
	}









	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", ville=" + ville + ", num=" + num
				+ ", besoinClient=" + besoinClient + "]";
	}

	
	
	

}