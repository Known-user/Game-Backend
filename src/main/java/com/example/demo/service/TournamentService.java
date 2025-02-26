package com.example.demo.service;

import com.example.demo.model.Tournament;
import com.example.demo.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public List<Tournament> getTournamentsByStatus(String status) {
        return tournamentRepository.findByStatus(status);
    }

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> searchTournaments(String query) {
        return tournamentRepository.searchTournaments(query);
    }
}
