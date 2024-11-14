package com.example.candidate_management.service;

import com.example.candidate_management.domain.Candidate;

import java.util.List;

public interface CandidateService {
    List<Candidate> findAll();
    Candidate findById(Long id);
    Candidate save(Candidate candidate);
    void deleteById(Long id);
}