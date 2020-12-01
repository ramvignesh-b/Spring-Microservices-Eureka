package me.ramvignesh.MVC2demo.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import me.ramvignesh.MVC2demo.dao.UserRepo;
import me.ramvignesh.MVC2demo.model.UserModel;
import me.ramvignesh.MVC2demo.model.login;

@RestController
public class UserController {
	@Autowired
	UserRepo repo;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/*DB Create Operation*/
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody UserModel user) {	
		
		String response;
		URI uRI = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		try {
			repo.save(user);
			response = "Created";
		}
		catch (Exception e) {
			response = "Failed";
		}
		/* Return the response to Microservice 1 */
		return ResponseEntity.created(uRI).body(response);
	}
	
	/* Credential Authentication */
	@PostMapping("/login") 
	public ResponseEntity<Object> login(@RequestBody login login) {
		
		String username = login.getUsername();
		String password = login.getPassword();
		boolean flag = false;
		
		URI uRI = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
		try{
			/* Check DB if username exists */
			if(!repo.findByUsername(username).getPassword().equals(null)) {
				if(password.equals(repo.findByUsername(username).getPassword())) {
					flag = true;
				}
			}	
		}
		catch(Exception e) {
			flag = false;
		}
		
		/* Return the response to Microservice 1 */
		return ResponseEntity.created(uRI).body(flag);
	}
}
