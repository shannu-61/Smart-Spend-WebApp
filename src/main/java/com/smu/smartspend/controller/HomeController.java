package com.smu.smartspend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Indicates that this class is a Spring MVC controller it will handle HTTP
			// requests
@RequestMapping("/")
public class HomeController {

	// Handles requests to the root URL ("/") and returns the "index" template
	public String index() {
		return "index"; // Return the name of the Thymeleaf template (without the ".html" extension)
	}
	@GetMapping("/signin")public String signin() {
		return "signin";
	}
}
