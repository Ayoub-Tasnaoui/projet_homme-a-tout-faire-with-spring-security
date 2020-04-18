package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BesoinClient;
import com.example.demo.dao.Bricoleur;
import com.example.demo.dao.ServiceBrico;
import com.example.demo.service.BesoinClientService;
import com.example.demo.service.BricoleurService;
import com.example.demo.service.ServiceBricoService;

@Controller
public class HomeController {

	@Autowired
	ServiceBricoService bS;

	@Autowired
	BesoinClientService bCS;
	
	@Autowired
	BricoleurService bricoleurService;

	@RequestMapping("/")
	public String home(Model m) {
	
		
	
		m.addAttribute("te", "Travaux d'électricité");
		m.addAttribute("tpp", "Travaux de plâtrerie peinture");
		m.addAttribute("tm","Travaux de menuiserie");
		m.addAttribute("tp","Travaux de plomberie");
		m.addAttribute("tma","Travaux de maçonnerie");
		m.addAttribute("ti","Travaux d'installation");
		m.addAttribute("td","\"Travaux de décoration\"");
	
		

		return "homePage";
	}
	
	@RequestMapping("/homeBricoleurPage/{id}")
	public String homeBricoleurPage(@PathVariable("id") int id,Model m) {
		List<ServiceBrico> ServicesBricos = new ArrayList<>();

		ServicesBricos = bS.getall();

		m.addAttribute("ServicesBricos", ServicesBricos);

		List<BesoinClient> besoinsClients = new ArrayList<>();

		besoinsClients = bCS.getall();

		m.addAttribute("besoinsClients", besoinsClients);
		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id);
		m.addAttribute("bricoleur", bricoleur);

		return "homeBricoleurPage";
	}
	
	

}

