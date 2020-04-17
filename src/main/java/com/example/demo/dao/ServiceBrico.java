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
public class ServiceBrico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_service;
	private String nomService;
	private String description;
	private String prix;
	
	@Column(name = "DATE_PUB")
	private LocalDate date_publication;
	
	@Column(name = "DATE_PUB_Heure")
	private LocalTime date_publication_Heure;
	

	@ManyToOne
	@JoinColumn(name = "ID_Brico")
	private Bricoleur bricoleur;
	
	public ServiceBrico() {
		// TODO Auto-generated constructor stub
	}

	public ServiceBrico( String nomService, String description, String prix,LocalDate date_publication,LocalTime date_publication_Heure,
			Bricoleur bricoleur) {
		super();
		
		this.nomService = nomService;
		this.description = description;
		this.prix = prix;
		this.date_publication = date_publication;
		this.date_publication_Heure = date_publication_Heure;
		this.bricoleur = bricoleur;
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

	@Override
	public String toString() {
		return "ServiceBrico [id_service=" + id_service + ", nomService=" + nomService + ", description=" + description
				+ ", prix=" + prix + ", date_publication=" + date_publication + ", date_publication_Heure="
				+ date_publication_Heure + ", bricoleur=" + bricoleur + "]";
	}

	
	
	

}
