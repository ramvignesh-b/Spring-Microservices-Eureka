package me.ramvignesh.MVC2demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Mvc2demoApplication {
	public static void main(String[] args) {
		SpringApplication.run(Mvc2demoApplication.class, args);
	}

}
