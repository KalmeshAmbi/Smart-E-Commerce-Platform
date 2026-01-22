package com.example.user_service.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
@Data
public class UserDto {
	private long id;
    private String name;
    private String emailId;
    private String phoneNO;
    private String gender;
    private LocalDate dateOfBirth;
    private int age;
    private List<AddressDto> addresses; // DTO version of Address
    private String role;

}
