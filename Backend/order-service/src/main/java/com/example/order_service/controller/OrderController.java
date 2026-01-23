package com.example.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
   @Autowired
    private  OrderService service;


    @PostMapping
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto dto) {
        return new ResponseEntity<>(service.createOrder(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getOrdersByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll() {
        return ResponseEntity.ok(service.getAllOrders());
    }
}
