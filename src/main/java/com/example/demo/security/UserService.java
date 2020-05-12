package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Bricoleur;

@Service
public class UserService {
	
    private UserRepository userRepository;
   
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
                       
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
      
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

  

    public Bricoleur findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public Bricoleur save(Bricoleur user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      
        return userRepository.save(user);
    }

}
