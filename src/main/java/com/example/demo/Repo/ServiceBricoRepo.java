package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dao.ServiceBrico;


public interface ServiceBricoRepo extends JpaRepository<ServiceBrico, Integer> {
	
	
	@Query(" from ServiceBrico Order By date_publication desc, date_publication_Heure desc")
	 List<ServiceBrico> findServices();
    
	@Query("from ServiceBrico where ID_Brico= :id_Brico Order By date_publication desc, date_publication_Heure desc")
	List<ServiceBrico> findSBOB(@Param("id_Brico")int id);
	
	  @Query("from ServiceBrico where  nom_service= :nom_service Order By date_publication desc, date_publication_Heure desc"
	  ) public List<ServiceBrico> findByServiceNom(@Param("nom_service") String nomService);
	 




}
