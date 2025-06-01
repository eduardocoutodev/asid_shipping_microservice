package com.ijse.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.bookstore.entity.ShippingOrder;
import com.ijse.bookstore.service.ShippingOrderService;


@RestController
public class ShippingOrderController {
    
    @Autowired
    private ShippingOrderService shippingOrderService;

    @GetMapping("/shipping")
    public ResponseEntity<List<ShippingOrder>> getAllShippingOrders(){
        List<ShippingOrder> shippedOrder = shippingOrderService.getAllShippingOrders();

        return new ResponseEntity<>(shippedOrder,HttpStatus.OK);
    }
}
