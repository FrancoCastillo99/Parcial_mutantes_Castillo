package com.example.mutantes_castillo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest  // Permite ejecutar la prueba en el contexto de Spring Boot
class MutantDetectionServiceTest {

    @Autowired
    private MutantService mutantService;

    @Test
    void testIsMutantWithMutantDNA() {
        String[] mutantDNA = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };

        boolean result = mutantService.isMutant(mutantDNA);
        assertTrue(result, "El ADN debe ser detectado como mutante");
    }

    @Test
    void testIsMutantWithHumanDNA() {
        String[] humanDNA = {
                "ATGCGA",
                "CAGTGC",
                "TTATTT",
                "AGACGG",
                "GCGTCA",
                "TCACTG"
        };

        boolean result = mutantService.isMutant(humanDNA);
        assertFalse(result, "El ADN no debe ser detectado como mutante");
    }
}
