package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) {
        // Initialize dotenv
        Dotenv dotenv = Dotenv.load();

        // Set environment variables
        System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
        System.setProperty("DATABASE_USER", dotenv.get("DATABASE_USER"));
        System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));

        // Run Spring Boot application
        SpringApplication.run(AssignmentApplication.class, args);
    }
}
