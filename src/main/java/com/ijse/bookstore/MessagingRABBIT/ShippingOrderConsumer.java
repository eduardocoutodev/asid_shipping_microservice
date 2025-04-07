package com.shipping.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ShippingOrderConsumer {

    @RabbitListener(queues = "shipping.queue")
    public void receiveMessage(String orderId) {
        System.out.println("Novo pedido recebido para envio. Order ID: " + orderId);

        // Aqui irás processar o ID recebido, por exemplo:
        // Criar um novo ShippingOrder no serviço de shipping
        // ou guardar logs, ou qualquer outra ação relevante

        // Exemplo simples:
        // shippingOrderService.createShippingEntry(orderId);
    }
}
