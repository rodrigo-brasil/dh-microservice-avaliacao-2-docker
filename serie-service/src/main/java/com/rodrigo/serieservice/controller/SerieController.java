package com.rodrigo.serieservice.controller;

import com.rodrigo.serieservice.model.Serie;
import com.rodrigo.serieservice.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SerieController {

    @Autowired
    private SerieService serieService;

    @PostMapping("/save")
    public ResponseEntity<Serie> adicionarSerie(@RequestBody Serie serie) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.save(serie));
    }
}
