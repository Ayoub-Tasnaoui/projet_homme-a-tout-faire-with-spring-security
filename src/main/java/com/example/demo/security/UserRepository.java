package com.example.demo.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dao.Bricoleur;

public interface UserRepository extends JpaRepository<Bricoleur, Integer>{

	 Bricoleur findByUserName(String username);
}
