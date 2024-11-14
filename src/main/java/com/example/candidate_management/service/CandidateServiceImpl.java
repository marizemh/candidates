package com.example.candidate_management.service;

import com.example.candidate_management.domain.Candidate;
import com.example.candidate_management.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void deleteById(Long id) {
        candidateRepository.deleteById(id);
    }

    public List<Candidate> getAllCandidates() {
        return findAll();
    }

    public Candidate getCandidateById(long l) {
        return findById(l);
    }
}