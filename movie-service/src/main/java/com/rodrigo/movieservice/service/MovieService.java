package com.rodrigo.movieservice.service;

import com.rodrigo.movieservice.rabbit.RabbitMQSenderConfig;
import com.rodrigo.movieservice.model.Movie;
import com.rodrigo.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RabbitMQSenderConfig rabbitMQSenderConfig;

    public Movie save(Movie movie) {
        Movie newMovie =  movieRepository.save(movie);
        if(movieRepository.existsById(newMovie.getId())){
            rabbitMQSenderConfig.send(newMovie);
        }
            return newMovie;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
