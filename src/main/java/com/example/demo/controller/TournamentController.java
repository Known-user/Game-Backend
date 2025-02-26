package com.example.demo.controller;

import com.example.demo.model.Tournament;
import com.example.demo.service.TournamentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(origins = "*") 
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        Optional<Tournament> tournament = tournamentService.getTournamentById(id);
        return tournament.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public List<Tournament> getTournamentsByStatus(@PathVariable String status) {
        return tournamentService.getTournamentsByStatus(status);
    }
    @GetMapping("/search")
    public List<Tournament> searchTournaments(@RequestParam String query) {
        return tournamentService.searchTournaments(query);
    }

    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.createTournament(tournament);
    }
}
