package com.example.demo.dao;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ServiceBrico {

	@Id
	private int id_service;
	private String nomService;
	private String description;
	private String prix;
	private Date date_publication;
	

	@ManyToOne
	@JoinColumn(name = "ID_Brico")
	private Bricoleur bricoleur;

	public int getId_service() {
		return id_service;
	}

	public void setId_service(int id_service) {
		this.id_service = id_service;
	}

	public Bricoleur getBricoleur() {
		return bricoleur;
	}

	public void setBricoleur(Bricoleur bricoleur) {
		this.bricoleur = bricoleur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
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
	
	

}
