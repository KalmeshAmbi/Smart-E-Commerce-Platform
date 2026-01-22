package com.example.address_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.address_service.entity.AddressEntity;
@Repository

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{
	 List<AddressEntity> findByUserId(Long userId);
}
