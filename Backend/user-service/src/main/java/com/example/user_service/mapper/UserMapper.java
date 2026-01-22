package com.example.user_service.mapper;



import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.UserEntity;

public class UserMapper {

    // Entity → DTO
    public static UserDto mapToUserDto(UserEntity user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmailId(user.getEmailId());
//        dto.setPhoneNo(user.getPhoneNo());
        dto.setGender(user.getGender());
        dto.setDateOfBirth(user.getDateOfBirth());
        dto.setAge(user.getAge());
        dto.setRole(user.getRole());

        return dto;
    }

    // DTO → Entity (CREATE)
    public static UserEntity mapToUserEntity(UserDto dto) {
        UserEntity user = new UserEntity();
        user.setName(dto.getName());
        user.setEmailId(dto.getEmailId());
        user.setPhoneNo(dto.getPhoneNo());
        user.setGender(dto.getGender());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setAge(dto.getAge());
        user.setRole(dto.getRole());

       
        return user;
    }
}
