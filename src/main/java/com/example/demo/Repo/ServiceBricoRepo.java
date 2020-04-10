package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dao.ServiceBrico;



public interface ServiceBricoRepo extends JpaRepository<ServiceBrico, Integer> {
	
	
	@Query(" from ServiceBrico Order By date_publication desc")
	 List<ServiceBrico> findServices();

}
