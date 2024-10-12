package com.example.mutantes_castillo.repository;

import com.example.mutantes_castillo.entity.DnaRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRecordRepository extends JpaRepository<DnaRecord, Long> {
    long countByIsMutant(boolean isMutant);
}
