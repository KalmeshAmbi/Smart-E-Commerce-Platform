package com.example.user_service.service;

import java.util.List;

import com.example.user_service.dto.UserDto;

public interface UserService {
	UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUser);

    void deleteUser(Long userId);
}
