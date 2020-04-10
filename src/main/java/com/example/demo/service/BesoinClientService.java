package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.BesoinClientRepo;
import com.example.demo.dao.BesoinClient;

@Service
public class BesoinClientService {
	
	

	@Autowired
	BesoinClientRepo repo;
	
	public List<BesoinClient> getall(){
		return repo.findBesoins();
	}

}
