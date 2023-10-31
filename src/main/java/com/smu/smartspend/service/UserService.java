package com.smu.smartspend.service;

import com.smu.smartspend.model.User;

public interface UserService {
	// Register a new user.
	void registerUser(User user);

	// Authenticate a user based on their email and password.
	// Returns true if the authentication is successful, false otherwise.
	boolean authenticateUser(String email, String password);

	// Find a user by their email.
	User findByEmail(String email);
}
