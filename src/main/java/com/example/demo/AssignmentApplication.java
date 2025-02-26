package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class AssignmentApplication {

    public static void main(String[] args) {
        // Initialize dotenv with 'ignoreIfMissing' to prevent errors if .env is not found
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        // Optionally, set environment variables with fallback to system environment if .env is missing
        String databaseUrl = dotenv.get("DATABASE_URL", System.getenv("DATABASE_URL"));
        String databaseUser = dotenv.get("DATABASE_USER", System.getenv("DATABASE_USER"));
        String databasePassword = dotenv.get("DATABASE_PASSWORD", System.getenv("DATABASE_PASSWORD"));

        // Set environment variables
        System.setProperty("DATABASE_URL", databaseUrl);
        System.setProperty("DATABASE_USER", databaseUser);
        System.setProperty("DATABASE_PASSWORD", databasePassword);

        // Run Spring Boot application
        SpringApplication.run(AssignmentApplication.class, args);
    }
}
