package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginPage() {

		return "login/loginForm";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {

		return "login/access-denied";
	}
}