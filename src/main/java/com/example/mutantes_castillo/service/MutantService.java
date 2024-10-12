package com.example.mutantes_castillo.service;

import com.example.mutantes_castillo.entity.DnaRecord;
import com.example.mutantes_castillo.repository.DnaRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutantService {

    @Autowired
    private DnaRecordRepository dnaRecordRepository;

    public boolean isMutant(String[] adn) {
        int contadorTotal = 0;
        int n = adn.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                contadorTotal += verificarSecuencia(adn, i, j, n);

                if (contadorTotal > 1) {
                    return true;  // Si encontramos más de una secuencia, es mutante
                }
            }
        }
        return false;  // No es mutante si no encontramos más de 1 secuencia
    }

    public int verificarSecuencia(String[] dna, int i, int j, int n) {
        char letra = dna[i].charAt(j);
        int contador = 0;

        // Verificar horizontalmente (hacia la derecha)
        if (j + 3 < n && (j == 0 || letra != dna[i].charAt(j - 1)) &&
                letra == dna[i].charAt(j + 1) && letra == dna[i].charAt(j + 2) && letra == dna[i].charAt(j + 3)) {
            contador++;
        }

        // Verificar verticalmente (hacia abajo)
        if (i + 3 < n && (i == 0 || letra != dna[i - 1].charAt(j)) &&
                letra == dna[i + 1].charAt(j) && letra == dna[i + 2].charAt(j) && letra == dna[i + 3].charAt(j)) {
            contador++;
        }

        // Verificar diagonalmente (hacia abajo a la derecha)
        if (i + 3 < n && j + 3 < n && (i == 0 || j == 0 || letra != dna[i - 1].charAt(j - 1)) &&
                letra == dna[i + 1].charAt(j + 1) && letra == dna[i + 2].charAt(j + 2) && letra == dna[i + 3].charAt(j + 3)) {
            contador++;
        }

        // Verificar diagonalmente (hacia abajo a la izquierda)
        if (i + 3 < n && j - 3 >= 0 && (i == 0 || j == n - 1 || letra != dna[i - 1].charAt(j + 1)) &&
                letra == dna[i + 1].charAt(j - 1) && letra == dna[i + 2].charAt(j - 2) && letra == dna[i + 3].charAt(j - 3)) {
            contador++;
        }

        return contador;
    }

    // Método para crear y guardar el registro en la base de datos
    public void saveDnaRecord(String[] dna, boolean isMutant) {
        DnaRecord dnaRecord = new DnaRecord();
        dnaRecord.setDna(List.of(dna)); // Convertir el array en List<String>
        dnaRecord.setMutant(isMutant);
        dnaRecordRepository.save(dnaRecord);
    }
}



