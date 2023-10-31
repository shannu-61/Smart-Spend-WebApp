package com.smu.smartspend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smu.smartspend.model.User;

//This interface extends JpaRepository, which provides CRUD operations for User entities.
public interface UserRepository extends JpaRepository<User, Integer> {

	// Custom query method to find a user by their username.
	User findByUsername(String username);

	// Custom query method to find a user by their email.
	User findByEmail(String email);
}