package com.rodrigo.movieservice.rabbit;

import com.rodrigo.movieservice.DTO.MovieDTO;
import com.rodrigo.movieservice.model.Movie;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.movie.name}")
    private String movieQueueName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue movieQueue() {
        return new Queue(movieQueueName);
    }

    public void send(Movie movie) {
        MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getName(), movie.getGenre(), movie.getUrlStream());
        rabbitTemplate.convertAndSend(movieQueueName, movieDTO);
    }
}
