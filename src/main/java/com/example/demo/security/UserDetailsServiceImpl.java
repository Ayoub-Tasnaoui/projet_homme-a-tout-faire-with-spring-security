package com.example.demo.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Bricoleur;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Bricoleur user = userRepository.findByUserName(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				grantedAuthorities);
	}

}
