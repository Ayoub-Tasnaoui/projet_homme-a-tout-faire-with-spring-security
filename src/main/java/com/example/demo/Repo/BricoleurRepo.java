package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.Bricoleur;

public interface BricoleurRepo extends JpaRepository<Bricoleur, Integer> {

}
