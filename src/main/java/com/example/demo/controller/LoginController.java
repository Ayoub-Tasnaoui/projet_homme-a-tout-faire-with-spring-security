package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.Bricoleur;
import com.example.demo.service.BricoleurService;

@Controller
public class LoginController {
	
	
	@Autowired
	BricoleurService bservice;
	
	@GetMapping("/login")
	public String login() {
		
		
		return "login1";
	}
	
	
	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	public String saveProduct(@RequestParam("userName") String userName,@RequestParam("password") String password, Model m) {
		List<Bricoleur> bricoleurs=new ArrayList<Bricoleur>();
		bricoleurs=bservice.getall();
		/*
		 * String userNameValide = null; String passwordValide = null;
		 */
		
		
		for (Bricoleur bricoleur2 : bricoleurs) {
			/*
			 * if(bricoleur2.getUserName().equalsIgnoreCase(userName)){userNameValide=
			 * userName;System.out.println(userNameValide);}
			 * if(bricoleur2.getPassword().equalsIgnoreCase(password)){passwordValide=
			 * password;System.out.println(passwordValide);}
			 */
			
		
			
			if(bricoleur2.getUserName().equalsIgnoreCase(userName) && bricoleur2.getPassword().equalsIgnoreCase(password)) {
			
			
			
				
				Bricoleur bricoleur=new Bricoleur();
			bricoleur=bricoleur2;
			m.addAttribute("bricoleur", bricoleur);
			
				return "profilBricoleur";
			}
		}
		
		if(userName.length()<1 || password.length()<1 ) {
			m.addAttribute("Eror1", true);
			System.out.println("Eror1");
			
			return"login1";	
		}
		
		
		/*
		 * if(userNameValide.equalsIgnoreCase(userName)) { m.addAttribute("Eror3",
		 * true); System.out.println("Eror3");
		 * 
		 * return "login1";
		 * 
		 * } if(passwordValide.equalsIgnoreCase(password)) { m.addAttribute("Eror4",
		 * true); System.out.println("Eror4");
		 * 
		 * return "login1";
		 * 
		 * }
		 */
		 
		
	
		m.addAttribute("Eror2", true);
		System.out.println("Eror2");
	
		
		return "login1";
		
		
		
	}
	
	

}
