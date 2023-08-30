package com.waxes27.lmstemplate.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = {"${lms.rabbit.queue.name}"})
    public void consume(String message){
        System.out.println(message);
    }
}
