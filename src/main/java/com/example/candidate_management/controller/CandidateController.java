package com.example.candidate_management.controller;

import com.example.candidate_management.domain.Candidate;
import com.example.candidate_management.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        Candidate candidate = candidateService.findById(id);
        if (candidate == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(candidate);
    }

    @PostMapping
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return candidateService.save(candidate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate candidateDetails) {
        Candidate candidate = candidateService.findById(id);
        if (candidate == null) {
            return ResponseEntity.notFound().build();
        }
        candidate.setName(candidateDetails.getName());
        candidate.setEmail(candidateDetails.getEmail());
        candidate.setGender(candidateDetails.getGender());
        candidate.setSalaryExpected(candidateDetails.getSalaryExpected());
        Candidate updatedCandidate = candidateService.save(candidate);
        return ResponseEntity.ok(updatedCandidate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        Candidate candidate = candidateService.findById(id);
        if (candidate == null) {
            return ResponseEntity.notFound().build();
        }
        candidateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}