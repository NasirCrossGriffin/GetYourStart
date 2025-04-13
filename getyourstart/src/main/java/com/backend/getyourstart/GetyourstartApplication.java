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

		System.setProperty("APP_KEY", dotenv.get("APP_KEY"));
		System.setProperty("APP_ID", dotenv.get("APP_ID"));

		SpringApplication.run(GetyourstartApplication.class, args);
	}

}
