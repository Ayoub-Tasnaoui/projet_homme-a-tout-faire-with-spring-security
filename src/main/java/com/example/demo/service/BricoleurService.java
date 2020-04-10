package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repo.BricoleurRepo;
import com.example.demo.dao.Bricoleur;

@Service
public class BricoleurService {

	@Autowired
	BricoleurRepo repo;
	
	public List<Bricoleur> getall(){
		return repo.findAll();
	}
	
	public void add(Bricoleur b){
		repo.save(b);
	}
	
	public Bricoleur getOneBricoleur(int id) {
		
		return repo.findById(id).get();
		
	}
	
	
}
