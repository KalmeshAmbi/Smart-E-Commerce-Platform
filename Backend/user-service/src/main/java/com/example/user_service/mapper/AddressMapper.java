package com.example.user_service.mapper;

import com.example.user_service.dto.AddressDto;
import com.example.user_service.entity.Address;
import com.example.user_service.entity.UserEntity;

public class AddressMapper {

    // Entity → DTO
    public static AddressDto mapToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setHouseNo(address.getHouseNo());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setCountry(address.getCountry());
        addressDto.setPincode(address.getPincode());
        if(address.getUser() != null) {
        	addressDto.setUserId(address.getUser().getId());
        }
        return addressDto;
    }

    // DTO → Entity
    public static Address mapToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setHouseNo(addressDto.getHouseNo());
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setCountry(addressDto.getCountry());
        address.setPincode(addressDto.getPincode());

        // Only set user id reference if needed (caller should set full UserEntity)
        if(addressDto.getUserId() != null) {
            UserEntity user = new UserEntity();
            user.setId(addressDto.getUserId());
            address.setUser(user);
        }
        return address;
    }
}
