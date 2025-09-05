package com.galaxy.bakendapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BakendApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BakendApiRestApplication.class, args);
		System.out.println("BackendApiRestApplication started");
	}
}
