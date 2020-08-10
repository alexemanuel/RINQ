package com.rinq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class RinqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RinqApplication.class, args);		
	}
}
