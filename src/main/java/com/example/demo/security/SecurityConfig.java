package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled=true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	 
	
	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
	
		
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
System.out.println("bycrypt******************************************");
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() 
		.antMatchers("/","/erreurajouterBesoin").permitAll()
		.antMatchers("/afficheBricoleurs/**","/voirClient/**","/VoirBricoleur/**").permitAll()
		.antMatchers("/api/images").permitAll()
		.antMatchers("/BesoinsClient").permitAll()
		.antMatchers("/AjouterUneBesoin").permitAll()
		.antMatchers("/ServiceBrico").permitAll()
		.antMatchers("/addBricoleur").permitAll()
		//.antMatchers("/profilBricoleur").permitAll()
		.antMatchers("/erreur").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().defaultSuccessUrl("/profilBricoleur").permitAll()
		.and()
		.logout().logoutSuccessUrl("/").permitAll()
		.and()
		  .exceptionHandling().accessDeniedPage("/403");
		
		//http.csrf().disable();
	}
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
