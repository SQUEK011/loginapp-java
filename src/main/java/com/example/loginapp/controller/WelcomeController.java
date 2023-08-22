package com.example.loginapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.loginapp.models.User;
import com.example.loginapp.services.UserServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

	private final UserServices userService;

	public WelcomeController(UserServices userService) {
		this.userService = userService;
	}

	@GetMapping("/welcome")
	public String showWelcomePage(HttpServletRequest request, Model model) {
		try {
			String username = userService.getRememberMeCookieValue(request);
			if (username != null && userService.isUserAuthenticated(username)) {
				User userDetails = userService.findByUsername(username);
				model.addAttribute("user", userDetails);
				return "welcome";
			} else {
				return "redirect:/login";
			}
		} catch (Exception e) {
			System.out.println("WelcomeController Exception: " + e.toString());
			return "redirect:/login";
		}

	}
}
