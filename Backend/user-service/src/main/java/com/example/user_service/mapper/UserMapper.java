package com.example.user_service.mapper;

package com.example.user_service.mapper;

import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {

    // Entity → DTO
    public static UserDto mapToUserDto(UserEntity user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmailId(user.getEmailId());
        userDto.setPhoneNO(user.getPhoneNO());
        userDto.setGender(user.getGender());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setAge(user.getAge());
        userDto.setRole(user.getRole());
        if(user.getAddresses() != null) {
        	userDto.setAddresses(
                user.getAddresses()
                    .stream()
                    .map(AddressMapper::mapToAddressDto)
                    .collect(Collectors.toList())
            );
        }
        return userDto;
    }

    // DTO → Entity (for Create)
    public static UserEntity mapToUserEntity(UserDto userDto) {
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setEmailId(userDto.getEmailId());
        user.setPhoneNO(userDto.getPhoneNO());
        user.setGender(userDto.getGender());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setAge(userDto.getAge());
        user.setRole(userDto.getRole());
        if(userDto.getAddresses() != null) {
            user.setAddresses(
            		userDto.getAddresses()
                    .stream()
                    .map(AddressMapper::mapToAddress)
                    .collect(Collectors.toList())
            );
        }
        return user;
    }
}

