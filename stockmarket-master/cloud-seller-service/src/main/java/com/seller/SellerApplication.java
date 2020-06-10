package com.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableResourceServer
@EnableOAuth2Client
public class SellerApplication {
	public static void main(String[] args)throws Exception{
		SpringApplication.run(SellerApplication.class, args);
	}
}
