package com.example.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.auth.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);   
}
