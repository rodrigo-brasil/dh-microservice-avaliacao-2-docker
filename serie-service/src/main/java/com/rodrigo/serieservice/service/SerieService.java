package com.rodrigo.serieservice.service;

import com.rodrigo.serieservice.model.Serie;
import com.rodrigo.serieservice.rabbit.RabbitMQSenderConfig;
import com.rodrigo.serieservice.repository.SerieRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerieService {
    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private RabbitMQSenderConfig rabbitMQSenderConfig;

    //TODO Implementar o serviço de adicionar chaptores e seasons a uma série ja existente.
    public Serie save(Serie serie) {
        Serie newSerie = serieRepository.save(serie);
        rabbitMQSenderConfig.send(newSerie);
        return newSerie;
    }
}
