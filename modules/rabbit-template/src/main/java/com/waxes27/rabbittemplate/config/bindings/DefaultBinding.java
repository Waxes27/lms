package com.waxes27.rabbittemplate.config.bindings;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultBinding {
    @Value("${rabbit.queue.name}")
    private String queue;
    @Value("${rabbit.queue.exchange.name}")
    private String exchange;
    @Value("${rabbit.queue.routing.key}")
    private String routingKey;

    @Bean
    public Queue queue(){
        return new Queue(queue);
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }
}
