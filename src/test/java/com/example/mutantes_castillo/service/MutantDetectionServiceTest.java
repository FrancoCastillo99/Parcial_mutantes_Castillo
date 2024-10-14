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

    @Test
    void testIsMutantWithExample1() {
        String[] dna = {
                "AAAA",
                "CCCC",
                "TCAG",
                "GGTC"
        };

        boolean result = mutantService.isMutant(dna);
        assertTrue(result, "El ADN debe ser detectado como mutante");
    }

    @Test
    void testIsMutantWithExample2() {
        String[] dna = {
                "TGAC",
                "AGCC",
                "TGAC",
                "GGTC"
        };

        boolean result = mutantService.isMutant(dna);
        assertTrue(result, "El ADN debe ser detectado como mutante");
    }

    @Test
    void testIsMutantWithExample3() {
        String[] dna = {
                "TGAC",
                "ATCC",
                "TAAG",
                "GGTC"
        };

        boolean result = mutantService.isMutant(dna);
        assertFalse(result, "El ADN no debe ser detectado como mutante");
    }

    @Test
    void testIsMutantWithExample4() {
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };

        boolean result = mutantService.isMutant(dna);
        assertFalse(result, "El ADN no debe ser detectado como mutante");
    }

    @Test
    void testIsMutantWithExample5() {
        String[] dna = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };

        boolean result = mutantService.isMutant(dna);
        assertTrue(result, "El ADN debe ser detectado como mutante");
    }

    @Test
    void testIsMutantWithExample6() {
        String[] dna = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };

        boolean result = mutantService.isMutant(dna);
        assertTrue(result, "El ADN debe ser detectado como mutante");
    }

    @Test
    void testIsMutantWithExample7() {
        String[] dna = {
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "TTTTTTTTT",
                "CCGACCAGT",
                "GGCACTCCA",
                "AGGACACTA",
                "CAAAGGCAT",
                "GCAGTCCCC"
        };

        boolean result = mutantService.isMutant(dna);
        assertTrue(result, "El ADN debe ser detectado como mutante");
    }
}
