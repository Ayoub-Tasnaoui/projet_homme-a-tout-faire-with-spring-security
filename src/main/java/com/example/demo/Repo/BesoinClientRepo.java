package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dao.BesoinClient;


	
	public interface BesoinClientRepo extends JpaRepository<BesoinClient, Integer> {
		
		@Query(" from BesoinClient Order By date_publication desc, date_publication_Heure desc")
		 List<BesoinClient> findBesoins();

	}


