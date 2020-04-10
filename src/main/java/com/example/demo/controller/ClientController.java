package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Client;
import com.example.demo.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	
	
	
	@RequestMapping("/voirClient/{id}")
	public String voirClient(@PathVariable("id") int id ,Model m) {
		Client client=new Client();
		client=clientService.getOneClient(id);
		m.addAttribute("client", client);
		
		return "voirClient";
	}
}
