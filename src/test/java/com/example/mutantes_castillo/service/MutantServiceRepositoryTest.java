package com.example.mutantes_castillo.service;

import com.example.mutantes_castillo.entity.DnaRecord;
import com.example.mutantes_castillo.repository.DnaRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class MutantServiceRepositoryTest {

    @Mock
    private DnaRecordRepository dnaRecordRepository;

    @InjectMocks
    private MutantService mutantService;

    // AutoCloseable para cerrar los mocks al final de cada prueba
    private AutoCloseable openMocks;

    @BeforeEach
    void setUp() {
        // Inicializar los mocks
        openMocks = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        // Cerrar los mocks después de cada prueba
        openMocks.close();
    }

    @Test
    void testSaveDnaRecord() {
        String[] dna = {
                "ATGCGA",
                "CAGTGC",
                "TTATGT",
                "AGAAGG",
                "CCCCTA",
                "TCACTG"
        };

        mutantService.saveDnaRecord(dna, true);

        // Verificar que el repositorio fue llamado con la entidad correcta
        verify(dnaRecordRepository, times(1)).save(any(DnaRecord.class));
    }
}