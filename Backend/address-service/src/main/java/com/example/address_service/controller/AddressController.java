package com.example.address_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.address_service.dto.AddressDto;
import com.example.address_service.services.AddressService;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // 📌 POST Address
    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(
                addressService.createAddress(addressDto),
                HttpStatus.CREATED
        );
    }

    // 📌 GET Address by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    // 📌 GET Addresses by User ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressDto>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(addressService.getAddressesByUserId(userId));
    }

    // 📌 GET All Addresses
    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }
}
