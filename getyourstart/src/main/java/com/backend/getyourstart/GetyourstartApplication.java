package com.backend.getyourstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;


@SpringBootApplication
public class GetyourstartApplication {

	public static void main(String[] args) {
		String environment = "";

		if (System.getenv("ENVIRONMENT") != null) {
			environment = System.getenv("ENVIRONMENT");
		} else {
			environment = "development";
		}
		
		System.out.println("GetYourStart is running in " + environment + " mode.");

        // Set system properties for Spring Boot
        if (environment.equals("development")) {
			Dotenv dotenv = Dotenv.configure()
			.directory("./")  // Adjust the path to your .env file
			.load();

			System.setProperty("ADZUNA_APP_KEY", dotenv.get("ADZUNA_APP_KEY"));
			System.setProperty("ADZUNA_APP_ID", dotenv.get("ADZUNA_APP_ID"));
			System.setProperty("RAPIDAPI_APP_KEY", dotenv.get("RAPIDAPI_APP_KEY"));
			System.setProperty("POSTGRES_URL", dotenv.get("POSTGRES_URL"));
			System.setProperty("POSTGRES_USERNAME", dotenv.get("POSTGRES_USERNAME"));
			System.setProperty("POSTGRES_PASSWORD", dotenv.get("POSTGRES_PASSWORD"));
		} else if (environment.equals("production")) {
			System.setProperty("ADZUNA_APP_KEY", System.getenv("ADZUNA_APP_KEY"));
			System.setProperty("ADZUNA_APP_ID", System.getenv("ADZUNA_APP_ID"));
			System.setProperty("RAPIDAPI_APP_KEY", System.getenv("RAPIDAPI_APP_KEY"));
			System.setProperty("POSTGRES_URL", System.getenv("POSTGRES_URL"));
			System.setProperty("POSTGRES_USERNAME", System.getenv("POSTGRES_USERNAME"));
			System.setProperty("POSTGRES_PASSWORD", System.getenv("POSTGRES_PASSWORD"));
		}

		SpringApplication.run(GetyourstartApplication.class, args);

		System.out.println("GetYourStart was launched successfully.");
	}
}
