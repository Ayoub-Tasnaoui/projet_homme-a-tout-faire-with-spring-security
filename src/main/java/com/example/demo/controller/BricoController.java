package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.Bricoleur;
import com.example.demo.service.BricoleurService;

@Controller
public class BricoController {

	@Autowired
	BricoleurService bservice;



	@RequestMapping("/bricoleurs")
	public String home1(Model m) {
		List<Bricoleur> bricoleurs=new ArrayList<>();
		
		bricoleurs=bservice.getall();
				
		m.addAttribute("bricoleurs", bricoleurs);
		
		return "Bricoleurspage";
	}
	
	@RequestMapping("/addBricoleur")
	public String showNewProductPage(Model model) {
		Bricoleur bricoleur = new Bricoleur();
		model.addAttribute("bricoleur", bricoleur);
		
		return "newBricoleur";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("Bricoleur") Bricoleur bricoleur) {
		bservice.add(bricoleur);
		
		return "redirect:/bricoleurs";
	}

	
	
	@RequestMapping("/VoirBricoleur/{id}")
	public String voirBricoleur(@PathVariable("id") int id ,Model m) {
		Bricoleur b=new Bricoleur();
		b=bservice.getOneBricoleur(id);
		m.addAttribute("b", b);
		
		return "voirBricoleur";
	}
	
	
	

}
