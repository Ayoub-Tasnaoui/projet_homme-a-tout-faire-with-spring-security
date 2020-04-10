package com.example.demo.dao;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BesoinClient {

	@Id
	private int id_Besoin;
	private String nomBesoin;
	private String description;
	private String prix;
	private Date date_publication;

	@ManyToOne
	@JoinColumn(name = "ID_client")
	private Client client;

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

	public Date getDate_publication() {
		return date_publication;
	}

	public void setDate_publication(Date date_publication) {
		this.date_publication = date_publication;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
