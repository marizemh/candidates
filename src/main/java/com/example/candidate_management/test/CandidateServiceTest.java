package com.example.candidate_management.test;

import com.example.candidate_management.domain.Candidate;
import com.example.candidate_management.repository.CandidateRepository;
import com.example.candidate_management.service.CandidateServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CandidateServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateServiceImpl candidateService;

    public CandidateServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCandidates() {
        Candidate candidate1 = new Candidate();
        candidate1.setName("John Doe");

        Candidate candidate2 = new Candidate();
        candidate2.setName("Jane Smith");

        when(candidateRepository.findAll()).thenReturn(Arrays.asList(candidate1, candidate2));

        List<Candidate> candidates = candidateService.getAllCandidates();
        assertEquals(2, candidates.size());
        verify(candidateRepository, times(1)).findAll();
    }

    @Test
    public void testGetCandidateById() {
        Candidate candidate = new Candidate();
        candidate.setName("John Doe");

        when(candidateRepository.findById(1L)).thenReturn(Optional.of(candidate));

        Candidate foundCandidate = candidateService.getCandidateById(1L);
        assertNotNull(foundCandidate);
        assertEquals("John Doe", foundCandidate.getName());
        verify(candidateRepository, times(1)).findById(1L);
    }

    // Add more tests for create, update, and delete methods
}
