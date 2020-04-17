package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dao.ServiceBrico;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface ServiceBricoRepo extends JpaRepository<ServiceBrico, Integer> {
	
	
	@Query(" from ServiceBrico Order By date_publication, date_publication_Heure desc")
	 List<ServiceBrico> findServices();
    
	@Query("from ServiceBrico where ID_Brico= :id_Brico")
	List<ServiceBrico> findSBOB(@Param("id_Brico")int id);



}
