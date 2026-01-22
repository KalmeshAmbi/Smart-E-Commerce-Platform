package com.example.user_service.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.user_service.dto.UserDto;
import com.example.user_service.entity.UserEntity;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
   @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
    	
        UserEntity user = UserMapper.mapToUserEntity(userDto);
        
        UserEntity savedUser = userRepository.save(user);
        
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmailId(updatedUser.getEmailId());
        existingUser.setPhoneNo(updatedUser.getPhoneNo());
        existingUser.setGender(updatedUser.getGender());
        existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
        existingUser.setAge(updatedUser.getAge());
        existingUser.setRole(updatedUser.getRole());

        UserEntity savedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
