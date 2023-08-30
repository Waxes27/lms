package com.waxes27.rabbittemplate.publisher;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class RabbitMQProducer {

    @Value("${lms.rabbit.queue.exchange.name}")
    private String lmsExchange;
    @Value("${rabbit.queue.exchange.name}")
    private String exchange;
    @Value("${lms.rabbit.queue.routing.key}")
    private String lmsRoutingKey;
    @Value("${rabbit.queue.routing.key}")
    private String routingKey;
    @Value("${rabbit.queue.name}")
    private String queue;

    @Value("${lms.rabbit.queue.name}")
    private String lmsQueue;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void broadcast(String message){
        rabbitTemplate.convertAndSend(lmsExchange,lmsRoutingKey,message);
        rabbitTemplate.convertAndSend(exchange,routingKey, message);

    }
}
