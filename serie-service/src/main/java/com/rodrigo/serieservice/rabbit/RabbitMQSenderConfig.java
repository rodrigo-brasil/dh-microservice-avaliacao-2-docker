package com.rodrigo.serieservice.rabbit;

import com.rodrigo.serieservice.model.Serie;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.serie.name}")
    private String serieQueueName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue serieQueue() {
        return new Queue(serieQueueName,true);
    }

    public void send(Serie serie) {
        rabbitTemplate.convertAndSend(serieQueueName, serie);
    }

}
