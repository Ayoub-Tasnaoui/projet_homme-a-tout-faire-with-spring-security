package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
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
	BricoleurService bricoleurService;

	@RequestMapping("/bricoleurs")
	public String home1(Model m) {
		List<Bricoleur> bricoleurs = new ArrayList<>();

		bricoleurs = bricoleurService.getall();

		m.addAttribute("bricoleurs", bricoleurs);

		return "Bricoleurspage";
	}

	@RequestMapping(value = "/addBricoleur")
	public String showNewProductPage(Model model) {
		Bricoleur bricoleur = new Bricoleur();
		model.addAttribute("bricoleur", bricoleur);
		List<String> ville= Arrays.asList("Casablanca","Fes","Rabat","Tanger","Marrakesh");
		model.addAttribute("ville",ville);

		return "newBricoleur";
	}

	@RequestMapping(value = "/erreur", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("bricoleur") Bricoleur bricoleur, Model m) {
		
		if(bricoleur.getUserName().length()<1 || bricoleur.getNom().length()<1 || bricoleur.getNum().length()<1 ||
				bricoleur.getPrenom().length()<1 || bricoleur.getVille().length()<1 || bricoleur.getPassword().length()<1 ) {
			m.addAttribute("Eror1", true);
			System.out.println("Eror1");
			List<String> ville= Arrays.asList("Casablanca","Fes","Rabat","Tanger","Marrakesh");
			m.addAttribute("ville",ville);
			return "newBricoleur";
		}
		List<Bricoleur> bricoleurs=new ArrayList<Bricoleur>();
		bricoleurs = bricoleurService.getall();
		for (Bricoleur bricoleur2 : bricoleurs) {
			if(bricoleur2.getUserName().equals(bricoleur.getUserName())) {
				m.addAttribute("Eror2", true);
				System.out.println("Eror2");
				List<String> ville= Arrays.asList("Casablanca","Fes","Rabat","Tanger","Marrakesh");
				m.addAttribute("ville",ville);
				return "newBricoleur";	
			}
		}
		
		bricoleurService.add(bricoleur);
		
		return "redirect:/login";
	}

	@RequestMapping("/VoirBricoleur/{id}")
	public String voirBricoleur(@PathVariable("id") int id, Model m) {
		Bricoleur b = new Bricoleur();
		b = bricoleurService.getOneBricoleur(id);
		m.addAttribute("b", b);

		return "voirBricoleurByAll";
		
		
	}
	@RequestMapping(value = "/VoirBricoleur/{id}/byOneBrico/{id1}",method = RequestMethod.GET)
	public String voirBricoleur2(@PathVariable("id") int id, @PathVariable("id1") int id1, Model m) {
		Bricoleur b = new Bricoleur();
		b = bricoleurService.getOneBricoleur(id);
		m.addAttribute("b", b);
		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id1);
		m.addAttribute("bricoleur", bricoleur);

		return "voirBricoleur";
	}
	
	
	
	@RequestMapping("/profil_Bricoleur/{id}")
	public String profilBricoleur(@PathVariable("id") int id, Model m) {
		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id);
		m.addAttribute("bricoleur", bricoleur);

		return "profilBricoleur";
	}

}
