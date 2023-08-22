package com.example.loginapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.loginapp.models.User;
import com.example.loginapp.services.UserServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class RestrictedController {

	private UserServices userService;

	public RestrictedController(UserServices userService) {
		this.userService = userService;
	}

	@GetMapping("/restricted")
	public String restricted(HttpServletRequest request, Model model) {
		try {
			String username = userService.getRememberMeCookieValue(request);
			if (username != null && userService.isUserAuthenticated(username)) {
				User userDetails = userService.findByUsername(username);
				if (userDetails.getRole().getName().equals("Manager")) {
					model.addAttribute("user", userDetails);
					return "restricted";
				} else {
					return "redirect:/welcome?username=" + username;
				}
			} else {
				return "redirect:/login";
			}
		} catch (Exception e) {
			System.out.println("RestrictedController Exception: " + e.toString());
			return "redirect:/login";
		}

	}
}