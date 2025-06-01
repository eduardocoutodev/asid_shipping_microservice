package com.ijse.bookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookstore.entity.ShippingOrder;
import com.ijse.bookstore.service.ShippingOrderService;

@RestController
public class ShippingOrderController {
    
    private final ShippingOrderService shippingOrderService;

    public ShippingOrderController(ShippingOrderService shippingOrderService) {
        this.shippingOrderService = shippingOrderService;
    }

    @GetMapping("/shipping")
    public ResponseEntity<List<ShippingOrder>> getAllShippingOrders(){
        List<ShippingOrder> shippedOrder = shippingOrderService.getAllShippingOrders();

        return new ResponseEntity<>(shippedOrder,HttpStatus.OK);
    }
}
