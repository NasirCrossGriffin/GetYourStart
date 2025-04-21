package com.backend.getyourstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class GetyourstartApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
			.directory("./")  // Adjust the path to your .env file
			.load();

		System.setProperty("ADZUNA_APP_KEY", dotenv.get("ADZUNA_APP_KEY"));
		System.setProperty("ADZUNA_APP_ID", dotenv.get("ADZUNA_APP_ID"));
		System.setProperty("RAPIDAPI_APP_KEY", dotenv.get("RAPIDAPI_APP_KEY"));
		System.setProperty("POSTGRES_URL", dotenv.get("POSTGRES_URL"));
		System.setProperty("POSTGRES_USERNAME", dotenv.get("POSTGRES_USERNAME"));
		System.setProperty("POSTGRES_PASSWORD", dotenv.get("POSTGRES_PASSWORD"));

		SpringApplication.run(GetyourstartApplication.class, args);
	}

}
