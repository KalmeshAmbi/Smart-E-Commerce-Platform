package com.example.address_service.mapper;


import com.example.address_service.dto.AddressDto;
import com.example.address_service.entity.AddressEntity;

public class AddressMapper {

    // DTO ➜ Entity
    public static AddressEntity mapToEntity(AddressDto dto) {
      

        AddressEntity entity = new AddressEntity();
        entity.setAddressId(dto.getAddressId());
        entity.setHouseNo(dto.getHouseNo());
        entity.setStreet(dto.getStreet());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setPincode(dto.getPincode());
        entity.setUserId(dto.getUserId());

        return entity;
    }

    // Entity ➜ DTO
    public static AddressDto mapToDto(AddressEntity entity) {
        

        AddressDto dto = new AddressDto();
        dto.setAddressId(entity.getAddressId());
        dto.setHouseNo(entity.getHouseNo());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setCountry(entity.getCountry());
        dto.setPincode(entity.getPincode());
        dto.setUserId(entity.getUserId());

        return dto;
    }
}

