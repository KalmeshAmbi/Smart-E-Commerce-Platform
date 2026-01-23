package com.example.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.product_service.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}

