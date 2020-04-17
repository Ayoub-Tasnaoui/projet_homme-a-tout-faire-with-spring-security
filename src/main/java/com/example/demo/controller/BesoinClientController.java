package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.BesoinClient;
import com.example.demo.dao.Client;
import com.example.demo.service.BesoinClientService;
import com.example.demo.service.ClientService;

@Controller
public class BesoinClientController {

	@Autowired
	BesoinClientService bCS;
	@Autowired
	ClientService cS;

	@RequestMapping("/BesoinsClient")
	public String home1(Model m) {
		List<BesoinClient> besoinsClients = new ArrayList<>();

		besoinsClients = bCS.getall();

		m.addAttribute("besoinsClients", besoinsClients);

		return "BesoinsClient";
	}
	
	
	
	
	
	
	@RequestMapping("/AjouterUneBesoin")
	public String ajouterService( Model m) {
		
		
		BesoinClient besoinClient=new BesoinClient();
		m.addAttribute("besoinClient", besoinClient);
		

		
		return "AjouterUneBesoin";
	}

	@RequestMapping(value = "/erreurajouterBesoin", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("besoinClient") BesoinClient   besoinClient,Model m) {
		
		
		if (besoinClient.getDescription().length() < 1 || besoinClient.getNomBesoin().length() < 1
				|| besoinClient.getPrix().length()<1 || besoinClient.getClient().getNom().length()<1 || besoinClient.getClient().getPrenom().length()<1
				|| besoinClient.getClient().getVille().length()<1  || besoinClient.getClient().getNum().length()<1) {
			m.addAttribute("Eror1", true);
			System.out.println("Eror1");
			return "AjouterUneBesoin";
		}
        
		LocalDate date_publication = LocalDate.now();
		LocalTime date_publication_Heure = LocalTime.now();
		besoinClient.setDate_publication(date_publication);
		besoinClient.setDate_publication_Heure(date_publication_Heure);
		
        cS.addClientAny(besoinClient.getClient());
		bCS.addBesoinClien(besoinClient);
		

		// return "profilBricoleur";

		return "redirect:/";
	}
	
	
	
	

}