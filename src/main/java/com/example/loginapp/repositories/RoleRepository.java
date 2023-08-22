package com.example.loginapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loginapp.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
