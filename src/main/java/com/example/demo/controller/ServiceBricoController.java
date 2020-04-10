package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.Bricoleur;
import com.example.demo.dao.ServiceBrico;
import com.example.demo.service.ServiceBricoService;

@Controller
public class ServiceBricoController {
	
	@Autowired
	ServiceBricoService bservice;



	@RequestMapping("/ServiceBrico")
	public String home1(Model m) {
		List<ServiceBrico> ServicesBricos=new ArrayList<>();
		Bricoleur bricoleur=new Bricoleur();
		
		ServicesBricos=bservice.getall();
		
		m.addAttribute("ServicesBricos", ServicesBricos);
		m.addAttribute("bricoleur", bricoleur);
		
		
		return "ServicesPage";
	}
	

}
