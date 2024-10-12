package com.example.mutantes_castillo.dto;
import com.example.mutantes_castillo.validators.ValidDna;
import lombok.Data;
import java.util.List;

@Data
public class DnaRequest {

    // Atributo que contiene la lista de secuencias de ADN
    @ValidDna
    private List<String> dna;

}
