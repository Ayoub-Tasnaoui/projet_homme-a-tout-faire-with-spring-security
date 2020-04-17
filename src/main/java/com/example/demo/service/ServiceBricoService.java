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
		
		public void add(ServiceBrico b){
			repo.save(b);
		}
		
		public List<ServiceBrico>  findServiceByOneBrico(int id){
			return repo.findSBOB(id);
		}


		public void updateService(ServiceBrico serviceBrico,int id) {
			repo.saveAndFlush(serviceBrico);

	   }

	   /*public void delete(int id) {
			ServiceBrico a=repo.getOne(id);
			repo.delete(a);
	   }*/
		public ServiceBrico get(int id){
			return repo.findById(id).get();
		}
		
		public void delete(int id){
			repo.deleteById(id);
		}

		public ServiceBrico findServiceVricoByOne(int id) {
			
			return null;
		}
}
