package com.example.user_service.dto;

import lombok.Data;

@Data
public class AddressDto {
	    private Long id;
	    private String houseNo;
	    private String street;
	    private String city;
	    private String state;
	    private String country;
	    private String pincode;
	    private Long userId; //

}
