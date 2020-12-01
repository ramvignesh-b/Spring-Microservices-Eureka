package me.ramvignesh.MVCdemo.controller;



import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import me.ramvignesh.MVCdemo.model.Login;
import me.ramvignesh.MVCdemo.model.User;

@RestController
public class restControl {
	
	/* Microservice 2 Application URL through Eureka Server */
	String url = "http://Eureka-client-2";
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
	      return new RestTemplate();
	  }
	
	@Autowired
	private RestTemplate rest;
	
	/* Index page */
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	
	/* Create User */
	@PostMapping("/register")
	public ModelAndView register(@ModelAttribute User user, ModelMap m) throws RestClientException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		/* Append the entity with User object*/
		HttpEntity<Object> request = new HttpEntity<>(user, headers);
		
		/* Exchange the registration request and response */
		ResponseEntity<String> response = rest.exchange(url+"/register", HttpMethod.POST, request, String.class);
		
		ModelAndView mv = new ModelAndView();
		
		/* Check if username/email already exists through response*/
		if(response.getBody().contains("Failed")) {
			mv.addObject("message","Username/Email already exists! (ಠ_ಠ)");
			mv.setViewName("error.jsp");
		}
		else {
			mv.addObject("username",user.getUsername());
			mv.addObject("message","Registration was successful 🚩 !");
			mv.setViewName("home.jsp");
		}
		return mv;
	}
	
	/* Authenticate User */
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute Login login, Model model) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Object> request = new HttpEntity<>(login, headers);
		
		/* Send the request to microservice 2 and get the authentication response */
		ResponseEntity<String> response = rest.exchange(url+"/login", HttpMethod.POST, request, String.class);
		ModelAndView mv = new ModelAndView();
		
		/* Check if credentials are correct */
		boolean isAuth = Boolean.parseBoolean(response.getBody());
		if(!isAuth) {
			mv.addObject("message","Username or Password incorrect! (ಠ_ಠ)");
			mv.setViewName("error.jsp");
		}
		else {
			mv.addObject("username",login.getUsername());
			mv.addObject("message","Welcome back \\(^_^)/ !");
			mv.setViewName("home.jsp");
		}
		
		return mv;
	}

}