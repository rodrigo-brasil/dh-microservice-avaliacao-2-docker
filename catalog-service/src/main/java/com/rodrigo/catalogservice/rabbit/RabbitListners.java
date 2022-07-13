package com.rodrigo.catalogservice.rabbit;

import com.rodrigo.catalogservice.DTO.MovieDTO;
import com.rodrigo.catalogservice.model.Movie;
import com.rodrigo.catalogservice.model.Serie;
import com.rodrigo.catalogservice.service.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitListners {

    @Autowired
    private RabbitTemplateConfig rabbitTemplateConfig;

    @Autowired
    private CatalogService catalogService;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receiveMovie(@Payload MovieDTO movie) {
        System.out.println("Received movie: " + movie.toString());
        Movie movieObj = new Movie(String.valueOf(movie.getId()), movie.getName(), movie.getGenre(), movie.getUrlStream());
        catalogService.saveMovieToCatalog(movieObj);
    }

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receiveMovie(@Payload Serie serie) {
        catalogService.saveSerieToCatalog(serie);
    }
}
