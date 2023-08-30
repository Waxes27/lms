package com.waxes27.lmstemplate.publisher;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service

public class RabbitMQProducer {

    @Value("${lms.rabbit.queue.name}")
    private String queue;
    @Value("${lms.rabbit.queue.exchange.name}")
    private String exchange;

    @Value("${lms.rabbit.queue.routing.key}")
    private String routingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(String message){
        System.out.println(message);
        rabbitTemplate.convertAndSend(exchange,routingKey,"Hello There");
    }
}
