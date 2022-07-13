package com.rodrigo.catalogservice.controller;

import com.rodrigo.catalogservice.model.Catalog;
import com.rodrigo.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/{genre}")
    public ResponseEntity<Catalog> getCatalogByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(catalogService.getCatalog(genre));
    }

}
