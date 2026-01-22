package com.example.address_service.services;

import java.util.List;

import com.example.address_service.dto.AddressDto;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);
    AddressDto getAddressById(Long id);
    List<AddressDto> getAddressesByUserId(Long userId);
    List<AddressDto> getAllAddresses();
}
