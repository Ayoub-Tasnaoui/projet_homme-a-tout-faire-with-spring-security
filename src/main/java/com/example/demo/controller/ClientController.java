package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.Bricoleur;
import com.example.demo.dao.Client;
import com.example.demo.service.BricoleurService;
import com.example.demo.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@Autowired
	BricoleurService bricoleurService;
	
	
	
	@RequestMapping("/voirClient/{id}")
	public String voirClient(@PathVariable("id") int id ,Model m) {
		Client client=new Client();
		client=clientService.getOneClient(id);
		m.addAttribute("client", client);
		
		return "voirClientByAll";
	}
	
	@RequestMapping(value = "/voirClient/{id}/byOneBrico/{id1}",method = RequestMethod.GET)
	public String voirBricoleur2(@PathVariable("id") int id, @PathVariable("id1") int id1, Model m) {
		Client client=new Client();
		client=clientService.getOneClient(id);
		m.addAttribute("client", client);           
		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id1);
		m.addAttribute("bricoleur", bricoleur);

		return "voirClient";
	}
	
	
}
