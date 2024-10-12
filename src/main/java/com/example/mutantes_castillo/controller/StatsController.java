package com.example.mutantes_castillo.controller;

import com.example.mutantes_castillo.dto.StatsResponse;
import com.example.mutantes_castillo.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping
    public ResponseEntity<StatsResponse> getStats() {
        StatsResponse stats = statsService.getStats();
        return new ResponseEntity<>(stats, HttpStatus.OK);  // Devuelve 200 OK explícitamente
    }
}

