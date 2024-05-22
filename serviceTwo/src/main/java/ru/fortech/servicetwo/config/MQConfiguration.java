package ru.fortech.servicetwo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfiguration {

    public static final String RECEIVE_QUEUE = "queue";
    public static final String RPC_EXCHANGE = "exchange";
    public static final String ROUTING_KEY = "key";

    @Bean
    public DirectExchange rpcExchange() {
        return new DirectExchange(RPC_EXCHANGE);
    }

    @Bean
    public Queue receiveQueue() {
        return new Queue(RECEIVE_QUEUE);
    }

    @Bean
    public Binding receiveBinding() {
        return BindingBuilder.bind(receiveQueue()).to(rpcExchange()).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}

