package com.example.mutantes_castillo.service;

import com.example.mutantes_castillo.dto.StatsResponse;
import com.example.mutantes_castillo.repository.DnaRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private DnaRecordRepository dnaRecordRepository;

    // Método para calcular las estadísticas
    public StatsResponse getStats() {
        long mutantCount = dnaRecordRepository.countByIsMutant(true);
        long humanCount = dnaRecordRepository.countByIsMutant(false);
        double ratio = humanCount > 0 ? (double) mutantCount / humanCount : 0;

        return new StatsResponse(mutantCount, humanCount, ratio);
    }
}
