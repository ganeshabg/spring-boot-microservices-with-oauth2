package com.example.oauth2.authorizationserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerApplication {

	public static void main(String[] args) {
		log.info("Authorisation server is getting started");
		SpringApplication.run(AuthorizationServerApplication.class, args);
	}

}
