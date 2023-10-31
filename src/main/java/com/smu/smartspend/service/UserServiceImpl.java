package com.smu.smartspend.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.smu.smartspend.model.User;
import com.smu.smartspend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void registerUser(User user) {

		// Save the user object to the database using the UserRepository.
		userRepository.save(user);
	}

	@Override
	public boolean authenticateUser(String email, String password) {
		// Find a user by email using the UserRepository.
		User user = userRepository.findByEmail(email);
		// Check if a user with the given email exists and if the provided password
		// matches the user's password.
		return user != null && user.getPassword().equals(password);
	}

	@Override
	public User findByEmail(String email) {
		// Find a user by email using the UserRepository and return the user object.
		return userRepository.findByEmail(email);
	}
}