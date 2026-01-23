package com.example.user_service.openFeignClient;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.address_service.dto.AddressDto;



@FeignClient(name = "address-service")
public interface AddressClient {
    @GetMapping("/api/addresses/user/{userId}")
    List<AddressDto> getAddressesByUserId(@PathVariable Long userId);
}