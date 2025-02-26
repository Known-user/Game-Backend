package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tournaments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tournament {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "game_name", nullable = false)
    private String gameName;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "prize_pool", nullable = false)
    private BigDecimal prizePool;

    @Column(nullable = false)
    private String status; // "Upcoming" or "Completed"

    @Column(columnDefinition = "TEXT")
    private String description;
}
