package com.ijse.bookstore.listener;

import com.ijse.bookstore.dto.OrderShippingConfirmation;
import com.ijse.bookstore.service.ShippingOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShippingOrderConsumer {

    private final ShippingOrderService shippingOrderService;

    public ShippingOrderConsumer(ShippingOrderService shippingOrderService) {
        this.shippingOrderService = shippingOrderService;
    }

    @RabbitListener(queues = "shipping.queue")
    public void receiveOrderConfirmation(OrderShippingConfirmation orderShippingConfirmation) {
        log.info("operation='receiveOrderConfirmation', message='Received order confirmation', ordershippingConfirmation={}", orderShippingConfirmation);
        shippingOrderService.createShippingOrder(orderShippingConfirmation);
        log.info("operation='receiveOrderConfirmation', message='Processed order confirmation'");
    }
}
