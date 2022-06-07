package com.example.securityexercise.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.securityexercise.constraints.UserRegistrationDto;
import com.example.securityexercise.models.User;

public interface UserService extends UserDetailsService {
	User findByEmail(String email);
	User save(UserRegistrationDto registration);
}
