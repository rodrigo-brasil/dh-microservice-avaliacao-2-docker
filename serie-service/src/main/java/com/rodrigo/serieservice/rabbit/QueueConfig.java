package com.rodrigo.serieservice.rabbit;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class QueueConfig {

    private AmqpAdmin amqpAdmin;

    @Value("${queue.serie.name}")
    private String serieQueueName;

    public QueueConfig(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @PostConstruct
    public void createQueues() {
        amqpAdmin.declareQueue(new Queue(serieQueueName, true));
    }

}
