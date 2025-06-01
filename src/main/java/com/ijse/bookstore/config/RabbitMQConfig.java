package com.ijse.bookstore.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String SHIPPING_QUEUE = "shipping.queue";
    public static final String SHIPPING_EXCHANGE = "shipping.exchange";
    public static final String SHIPPING_ROUTING_KEY = "shipping.routingkey";

    @Bean
    public Queue shippingQueue() {
        return new Queue(SHIPPING_QUEUE);
    }

    @Bean
    public TopicExchange shippingExchange() {
        return new TopicExchange(SHIPPING_EXCHANGE); // Cria uma exchange com o nome definido acima
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding shippingBinding(Queue shippingQueue, TopicExchange shippingExchange) {
        return BindingBuilder
                .bind(shippingQueue) // Fila de destino
                .to(shippingExchange) // Exchange de origem
                .with(SHIPPING_ROUTING_KEY); // Routing key usada na ligação
    }
}
