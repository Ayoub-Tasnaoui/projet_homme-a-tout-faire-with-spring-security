package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.ClientRepo;
import com.example.demo.dao.Client;

@Service
public class ClientService {
	
	@Autowired
	ClientRepo repo;
	
	
	
	public Client getOneClient(int id) {
		
		return repo.findById(id).get();
		
	}



	public void addClientAny(Client client) {
		repo.save(client);
		
	}
	
	
	
	
	

}
