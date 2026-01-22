package com.example.user_service.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "User")
@Data
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name",nullable = false)
    private String name;
	@Column(name = "email_id",nullable = false, unique = true)
    private String emailId;
	@Column(name = "phone_no", nullable = false, unique = true)
    private String phoneNO;
    private String gender;
    private LocalDate dateOfBirth; 
    private int age;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;
    @Column(nullable = false)
    private String role = "User"; 

}

