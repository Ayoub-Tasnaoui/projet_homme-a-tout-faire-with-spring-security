package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.BesoinClient;
import com.example.demo.service.BesoinClientService;


@Controller
public class BesoinClientController {
	

	
	@Autowired
	BesoinClientService bCS;



	@RequestMapping("/BesoinsClient")
	public String home1(Model m) {
		List<BesoinClient> besoinsClients=new ArrayList<>();
		
		
		besoinsClients=bCS.getall();
		
		m.addAttribute("besoinsClients", besoinsClients);
		
		
		
		return "BesoinsClient";
	}
}