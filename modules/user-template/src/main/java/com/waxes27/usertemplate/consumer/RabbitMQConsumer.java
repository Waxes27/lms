package com.waxes27.rabbittemplate.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = {"${rabbit.queue.name}"})
    public void consume(String message){
        System.out.println(message);
    }
}
