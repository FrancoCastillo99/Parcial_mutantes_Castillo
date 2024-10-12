package com.example.mutantes_castillo.controller;
import com.example.mutantes_castillo.dto.DnaRequest;
import com.example.mutantes_castillo.service.MutantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {

    @Autowired
    private MutantService mutantService;

    @PostMapping
    public ResponseEntity<String> detectMutant(@Valid @RequestBody DnaRequest dnaRequest) {
        // Convertimos la lista de ADN en un array de String
        String[] dnaArray = dnaRequest.getDna().toArray(new String[0]);

        // Verificamos si es mutante
        boolean isMutant = mutantService.isMutant(dnaArray);

        // Guardamos el registro en la base de datos a través del servicio
        mutantService.saveDnaRecord(dnaArray, isMutant);

        if (isMutant) {
            return ResponseEntity.ok("Mutante");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No Mutante");
        }
    }
}
