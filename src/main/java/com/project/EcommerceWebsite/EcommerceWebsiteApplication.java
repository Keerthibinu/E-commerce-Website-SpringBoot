package com.project.EcommerceWebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceWebsiteApplication.class, args);
		System.out.println("Application Running on http://localhost:8085");
	}

}
