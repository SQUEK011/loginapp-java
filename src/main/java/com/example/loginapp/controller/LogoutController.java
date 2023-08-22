package com.example.loginapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.loginapp.services.UserServices;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LogoutController {

	private final UserServices userService;

	public LogoutController(UserServices userService) {
		this.userService = userService;
	}

	@GetMapping("/logout")
	public String performLogout(HttpServletResponse response) {
		userService.forgetMe(response);
		return "redirect:/login?logout=true";
	}
}
