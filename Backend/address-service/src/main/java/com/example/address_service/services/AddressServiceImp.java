package com.example.address_service.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.address_service.dto.AddressDto;
import com.example.address_service.entity.AddressEntity;
import com.example.address_service.exceptions.ResourceNotFoundException;
import com.example.address_service.mapper.AddressMapper;
import com.example.address_service.repository.AddressRepository;

@Service
public class AddressServiceImp implements AddressService {
    @Autowired
    private  AddressRepository addressRepository;


    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        AddressEntity entity = AddressMapper.mapToEntity(addressDto);
        AddressEntity savedEntity = addressRepository.save(entity);
        return AddressMapper.mapToDto(savedEntity);
    }

    @Override
    public AddressDto getAddressById(Long id) {
        AddressEntity entity = addressRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("data not found")
                );
        return AddressMapper.mapToDto(entity);
    }

    @Override
    public List<AddressDto> getAddressesByUserId(Long userId) {
        return addressRepository.findByUserId(userId)
                .stream()
                .map(AddressMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(AddressMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
