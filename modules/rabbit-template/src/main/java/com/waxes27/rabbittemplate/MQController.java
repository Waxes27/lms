package com.waxes27.rabbittemplate;


import com.waxes27.rabbittemplate.publisher.RabbitMQProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("message")
@AllArgsConstructor
public class MQController {

    private RabbitMQProducer rabbitMQProducer;

    @GetMapping
    public void publish(){
        rabbitMQProducer.broadcast("Data");
    }
}
