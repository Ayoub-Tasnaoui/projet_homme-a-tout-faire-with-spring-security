package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.Bricoleur;
import com.example.demo.dao.ServiceBrico;
import com.example.demo.service.BricoleurService;
import com.example.demo.service.ServiceBricoService;

@Controller
public class ServiceBricoController {

	@Autowired
	ServiceBricoService bservice;

	@Autowired
	BricoleurService bricoleurService;

	@RequestMapping("/ServiceBrico")
	public String home1(Model m) {
		List<ServiceBrico> ServicesBricos = new ArrayList<>();
		Bricoleur bricoleur = new Bricoleur();

		ServicesBricos = bservice.getall();

		m.addAttribute("ServicesBricos", ServicesBricos);
		m.addAttribute("bricoleur", bricoleur);

		return "ServicePage";
	}

	@RequestMapping("/ajouterService/{id}")
	public String ajouterService(@PathVariable("id") int id, Model m) {
		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id);
		m.addAttribute("bricoleur", bricoleur);
		ServiceBrico serviceBrico = new ServiceBrico();
		List<String> nomService = Arrays.asList("Travaux de plâtrerie peinture", "Travaux de plomberie",
				"Travaux de maçonnerie",  "Travaux d'électricité", "Travaux de menuiserie", "Travaux d'installation",
				"Travaux de décoration");
		m.addAttribute("nomService", nomService);

		m.addAttribute("serviceBrico", serviceBrico);
		return "ajouterService";
	}

	@RequestMapping(value = "/erreurajouterService/{id}", method = RequestMethod.POST)
	public String saveProduct(@PathVariable("id") int id, @ModelAttribute("serviceBrico") ServiceBrico serviceBrico,
			Model m) {
		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id);
		m.addAttribute("bricoleur", bricoleur);
		if (serviceBrico.getDescription().length() < 1 || serviceBrico.getNomService().length() < 1
				|| serviceBrico.getPrix().length() < 1) {
			m.addAttribute("Eror1", true);
			System.out.println("Eror1");
			List<String> nomService = Arrays.asList("Travaux de plâtrerie peinture", "Travaux de plomberie",
					"Travaux de maçonnerie", "Travaux d'électricité", "Travaux de menuiserie", "Travaux d'installation",
					"Travaux de décoration");
			m.addAttribute("nomService", nomService);
			return "ajouterService";
		}

		LocalDate date_publication = LocalDate.now();
		LocalTime date_publication_Heure = LocalTime.now();
		serviceBrico.setDate_publication(date_publication);
		serviceBrico.setDate_publication_Heure(date_publication_Heure);
		serviceBrico.setBricoleur(bricoleur);

		bservice.add(serviceBrico);

		// return "profilBricoleur";

		return "redirect:/servicesByOneBrico/{id}";
	}

	@RequestMapping("/servicesByOneBrico/{id}")
	public String servicesByOneBrico(@PathVariable("id") int id, Model m) {
		List<ServiceBrico> ServicesBricos = new ArrayList<>();
		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id);
		m.addAttribute("bricoleur", bricoleur);
		ServicesBricos = bservice.findServiceByOneBrico(id);

		m.addAttribute("ServicesBricos", ServicesBricos);
		System.out.println(id);

		return "Services_Page";
	}

	/*
	 * @RequestMapping(value = "/EditBricoleur/{id}/byOneBrico/{id1}") public
	 * ModelAndView updateService(@PathVariable(name = "id_service") int id_service)
	 * { ModelAndView mav = new ModelAndView("editService"); ServiceBrico ser =
	 * bservice.get(id_service); mav.addObject("serviceBrico", ser);
	 * 
	 * return mav; }
	 */

	@RequestMapping(value = "/EditBricoleur/{id}/byOneBrico/{id1}")
	public ModelAndView updateService(@PathVariable("id") int id, @PathVariable("id1") int id1, Model m) {
		ModelAndView mav = new ModelAndView("editService");
		List<ServiceBrico> ServicesBricos = new ArrayList<>();
		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id1);
		m.addAttribute("bricoleur", bricoleur);
		ServicesBricos = bservice.findServiceByOneBrico(id1);
		List<String> nomService = Arrays.asList("Travaux de plâtrerie peinture", "Travaux de plomberie",
				"Travaux de maçonnerie", "Travaux d'électricité", "Travaux de menuiserie", "Travaux d'installation",
				"Travaux de décoration");
		
		
	

		m.addAttribute("nomService", nomService);

		m.addAttribute("ServicesBricos", ServicesBricos);
		System.out.println(id1);
		ServiceBrico ser = bservice.get(id);

		mav.addObject("serviceBrico", ser);
		bservice.add(ser);

		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveService(@ModelAttribute("serviceBrico") ServiceBrico serviceBrico, @PathVariable("id") int id) {

		bservice.updateService(serviceBrico,id);
		return "redirect:/servicesByOneBrico/{id1}";
	}

	@RequestMapping("DeleteBricoleur/{id}/byOneBrico/{id1}")
	public String servicesByOneBrico(@PathVariable("id") int id, @PathVariable("id1") int id1, Model m) {
		List<ServiceBrico> ServicesBricos = new ArrayList<>();

		ServicesBricos = bservice.findServiceByOneBrico(id1);

		ServiceBrico serviceBrico1 = new ServiceBrico();
		serviceBrico1 = bservice.findServiceBricoByOne(id);

		for (ServiceBrico serviceBrico : ServicesBricos) {
			if (serviceBrico.equals(serviceBrico1)) {
				bservice.delete(id);
				System.out.println("delete" + id);

			}
		}

		Bricoleur bricoleur = new Bricoleur();
		bricoleur = bricoleurService.getOneBricoleur(id1);
		m.addAttribute("bricoleur", bricoleur);

		m.addAttribute("ServicesBricos", ServicesBricos);
		System.out.println(id);

		return "redirect:/servicesByOneBrico/{id1}";
	}
	
	
	
	  @RequestMapping("/afficheBricoleurs/{nomService}")
	  public String afficheBricoleurs(Model  m,@PathVariable("nomService") String nomService) {
		 String nomServicee=null;
		
		 Set<Bricoleur> bricoleurs=new HashSet<Bricoleur>();
		  List<ServiceBrico> serviceBricos = new ArrayList<ServiceBrico>();
		 
		  serviceBricos= bservice.findByServiceNom1(nomService);
	for (ServiceBrico serviceBrico : serviceBricos) {
     
	Bricoleur bricoleur = new Bricoleur();
	 bricoleur=serviceBrico.getBricoleur();
			 bricoleurs.add(bricoleur);
			 nomServicee=serviceBrico.getNomService();
		
	}
	
		  
	 m.addAttribute("nomServicee",nomServicee);	
	  m.addAttribute("bricoleurs",bricoleurs);
	 
	 return "LesBricoleurs";
	 }
	 
	
	
	
	

}
