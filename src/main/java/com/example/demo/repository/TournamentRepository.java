package com.example.demo.repository;

import com.example.demo.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByStatus(String status);

    @Query("SELECT t FROM Tournament t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(t.gameName) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Tournament> searchTournaments(@Param("query") String query);
}