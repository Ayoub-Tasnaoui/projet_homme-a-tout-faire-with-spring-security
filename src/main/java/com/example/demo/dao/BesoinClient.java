package com.example.demo.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BesoinClient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_Besoin;
	private String nomBesoin;
	private String description;
	private String prix;
	
	
	
	@Column(name = "DATE_PUB")
	private LocalDate date_publication;
	
	@Column(name = "DATE_PUB_Heure")
	private LocalTime date_publication_Heure;
	

	@ManyToOne
	@JoinColumn(name = "ID_client")
	private Client client;

   public BesoinClient() {
	// TODO Auto-generated constructor stub
}
	
	public BesoinClient( String nomBesoin, String description, String prix, LocalDate date_publication,LocalTime date_publication_Heure,
			Client client) {
		super();
		
		this.nomBesoin = nomBesoin;
		this.description = description;
		this.prix = prix;
		this.date_publication = date_publication;
		this.date_publication_Heure =date_publication_Heure;
		this.client = client;
	}

	public LocalDate getDate_publication() {
		return date_publication;
	}

	public void setDate_publication(LocalDate date_publication) {
		this.date_publication = date_publication;
	}
	

	public LocalTime getDate_publication_Heure() {
		return date_publication_Heure;
	}

	public void setDate_publication_Heure(LocalTime date_publication_Heure) {
		this.date_publication_Heure = date_publication_Heure;
	}

	public int getId_Besoin() {
		return id_Besoin;
	}

	public void setId_Besoin(int id_Besoin) {
		this.id_Besoin = id_Besoin;
	}

	public String getNomBesoin() {
		return nomBesoin;
	}

	public void setNomBesoin(String nomBesoin) {
		this.nomBesoin = nomBesoin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}



	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "BesoinClient [id_Besoin=" + id_Besoin + ", nomBesoin=" + nomBesoin + ", description=" + description
				+ ", prix=" + prix + ", date_publication=" + date_publication + ", date_publication_Heure="
				+ date_publication_Heure + ", client=" + client + "]";
	}
	

}
