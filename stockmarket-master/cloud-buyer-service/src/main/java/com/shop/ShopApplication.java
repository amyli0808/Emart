package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableResourceServer
@EnableOAuth2Client
public class ShopApplication {
	public static void main(String[] args)throws Exception{
		SpringApplication.run(ShopApplication.class, args);
	}
}
