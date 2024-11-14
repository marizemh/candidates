package com.example.candidate_management.test;

import com.example.candidate_management.domain.Candidate;
import com.example.candidate_management.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CandidateRepositoryTest {

    @Autowired
    private CandidateRepository candidateRepository;

    @Test
    public void testFindAll() {
        List<Candidate> candidates = candidateRepository.findAll();
        assertFalse(candidates.isEmpty());
    }

    @Test
    public void testSave() {
        Candidate candidate = new Candidate();
        candidate.setName("New Candidate");
        candidate.setEmail("new.candidate@example.com");

        Candidate savedCandidate = candidateRepository.save(candidate);
        assertNotNull(savedCandidate.getId());
    }

    // Add more tests for findById, delete, etc.
}