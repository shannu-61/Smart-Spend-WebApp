package com.smu.smartspend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.smu.smartspend.model.User;
import com.smu.smartspend.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// Handles GET request to "/login" and returns the login page
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// Handles POST request to "/login" for user authentication
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,
			RedirectAttributes attributes) {
		// Authenticate the user using the UserService
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			attributes.addFlashAttribute("message", "Welcome to the Dashboard!");
			return "redirect:/dashboard"; // Redirect to the dashboard on success
		} else {
			attributes.addFlashAttribute("error", "Invalid email or password. Please try again.");
			return "redirect:/login"; // Redirect back to login page on failure
		}
	}

	// Handles GET request to "/dashboard" and returns the dashboard page
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		return "dashboard";
	}

	// Handles GET request to "/logout" for user logout
	@GetMapping("/logout")
	public String logout() {
		// Implement logout logic if needed
		return "redirect:/login"; // Redirect to the login page after logout
	}

	// Handles GET request to "/register" and returns the registration form
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User(0, "", "", "")); // Add an empty User object to the model

		return "register";
	}

	// Handles POST request to "/register" for user registration
	@PostMapping("/register")
	public String registerUser(User user) {
		userService.registerUser(user); // Register the user using the UserService
		return "redirect:/login"; // Redirect to login page after successful registration
	}
}