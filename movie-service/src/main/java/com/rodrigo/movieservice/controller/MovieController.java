package com.rodrigo.movieservice.controller;

import com.rodrigo.movieservice.model.Movie;
import com.rodrigo.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Movie movie){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(movie));
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAll());
    }
}
