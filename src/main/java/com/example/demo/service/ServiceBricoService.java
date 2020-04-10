package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.ServiceBricoRepo;
import com.example.demo.dao.ServiceBrico;
@Service
public class ServiceBricoService {
	
	

		@Autowired
		ServiceBricoRepo repo;
		
		public List<ServiceBrico> getall(){
			return repo.findServices();
		}
		
		
		
		
		

}
