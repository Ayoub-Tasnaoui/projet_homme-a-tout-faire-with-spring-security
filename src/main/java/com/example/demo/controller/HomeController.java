package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BesoinClient;
import com.example.demo.dao.ServiceBrico;
import com.example.demo.service.BesoinClientService;
import com.example.demo.service.ServiceBricoService;

@Controller
public class HomeController {

	@Autowired
	ServiceBricoService bS;

	@Autowired
	BesoinClientService bCS;

	@RequestMapping("/")
	public String home(Model m) {
		List<ServiceBrico> ServicesBricos = new ArrayList<>();

		ServicesBricos = bS.getall();

		m.addAttribute("ServicesBricos", ServicesBricos);

		List<BesoinClient> besoinsClients = new ArrayList<>();

		besoinsClients = bCS.getall();

		m.addAttribute("besoinsClients", besoinsClients);

		return "homePage";
	}

}
