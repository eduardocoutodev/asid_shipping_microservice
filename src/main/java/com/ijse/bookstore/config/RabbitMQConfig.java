package com.ijse.bookstore.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue shippingQueue(@Value("${service.shipping.queue.name}") String shippingQueue) {
        return new Queue(shippingQueue);
    }

    @Bean
    public TopicExchange shippingExchange(@Value("${service.shipping.exchange.name}") String shippingExchange) {
        return new TopicExchange(shippingExchange);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding shippingBinding(
            Queue shippingQueue,
            TopicExchange shippingExchange,
            @Value("${service.shipping.routing.name}") String shippingRouting
    ) {
        return BindingBuilder
                .bind(shippingQueue)
                .to(shippingExchange)
                .with(shippingRouting);
    }
}
