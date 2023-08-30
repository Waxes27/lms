package com.waxes27.rabbittemplate.config.bindings;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class LmsBinding {

    @Value("${lms.rabbit.queue.name}")
    private String lmsQueueName;
    @Value("${lms.rabbit.queue.exchange.name}")
    private String lmsExchangeName;
    @Value("${lms.rabbit.queue.routing.key}")
    private String lmsRoutingKeyName;


    @Bean
    public Queue lmsQueue(){
        return new Queue(lmsQueueName);
    }
    @Bean
    public TopicExchange lmsTopicExchange(){
        return new TopicExchange(lmsExchangeName);
    }
    @Bean
    public Binding lmsBinding(){
        return BindingBuilder
                .bind(lmsQueue())
                .to(lmsTopicExchange())
                .with(lmsRoutingKeyName);
    }

}
