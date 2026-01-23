package com.example.order_service.services;

import java.util.List;
import com.example.order_service.dto.OrderDto;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderById(Long id);
    List<OrderDto> getOrdersByUserId(Long userId);
    List<OrderDto> getAllOrders();
}
