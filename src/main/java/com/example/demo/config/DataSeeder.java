package com.example.demo.config;

import com.example.demo.model.Tournament;
import com.example.demo.repository.TournamentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(TournamentRepository tournamentRepository) {
        return args -> {
            if (tournamentRepository.count() == 0) {
                tournamentRepository.saveAll(List.of(
                    new Tournament(null, "Winter Clash 2025", "Valorant", LocalDate.of(2025, 3, 10), new BigDecimal("5000.00"), "Upcoming", "5v5, Best of 3, Open to all"),
                    new Tournament(null, "Apex Legends Showdown", "Apex Legends", LocalDate.of(2025, 2, 20), new BigDecimal("3000.00"), "Completed", "Trios, $1000 per player"),
                    new Tournament(null, "CS:GO Pro League", "CS:GO", LocalDate.of(2025, 4, 1), new BigDecimal("10000.00"), "Upcoming", "5v5, Bracket Style")
                ));
            }
        };
    }
}
