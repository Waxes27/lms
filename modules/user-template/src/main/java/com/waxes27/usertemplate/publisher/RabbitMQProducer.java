package com.waxes27.usertemplate.publisher;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class RabbitMQProducer {

    @Value("${rabbit.queue.name}")
    private String queue;
    @Value("${rabbit.queue.exchange.name}")
    private String exchange;

    @Value("${rabbit.queue.routing.key}")
    private String routingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(String message){
        System.out.println(message);
        rabbitTemplate.convertAndSend(exchange,routingKey,"Hello There");
    }
}
