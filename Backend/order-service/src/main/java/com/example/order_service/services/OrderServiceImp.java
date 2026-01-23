package com.example.order_service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.OrderEntity;
import com.example.order_service.exception.ResourceNotFoundException;
import com.example.order_service.mapper.OrderMapper;
import com.example.order_service.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {
   @Autowired
    private  OrderRepository repository;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        OrderEntity entity = OrderMapper.mapToEntity(orderDto);
        return OrderMapper.mapToDto(repository.save(entity));
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        return OrderMapper.mapToDto(entity);
    }

    @Override
    public List<OrderDto> getOrdersByUserId(Long userId) {
        return repository.findByUserId(userId)
                .stream()
                .map(OrderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return repository.findAll()
                .stream()
                .map(OrderMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
