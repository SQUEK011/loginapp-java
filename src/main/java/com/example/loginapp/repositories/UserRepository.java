package com.example.loginapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loginapp.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
