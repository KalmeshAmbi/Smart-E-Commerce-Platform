package com.example.product_service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_service.dto.ProductDto;
import com.example.product_service.entity.ProductEntity;
import com.example.product_service.exception.ResourceNotFoundException;
import com.example.product_service.mapper.ProductMapper;
import com.example.product_service.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
   @Autowired
    private ProductRepository repository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        ProductEntity entity = ProductMapper.mapToEntity(productDto);
        return ProductMapper.mapToDto(repository.save(entity));
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        return ProductMapper.mapToDto(entity);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(ProductMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        ProductEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        entity.setName(productDto.getName());
        entity.setDescription(productDto.getDescription());
        entity.setPrice(productDto.getPrice());
        entity.setQuantity(productDto.getQuantity());

        return ProductMapper.mapToDto(repository.save(entity));
    }

    @Override
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}

