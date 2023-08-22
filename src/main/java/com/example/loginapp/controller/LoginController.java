package com.example.loginapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.loginapp.services.UserServices;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

	private final UserServices userService;

	public LoginController(UserServices userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String showLoginPage(HttpServletRequest request) {
		String username = getRememberMeCookieValue(request);
		if (username != null) {
			return "redirect:/welcome?username=" + username;
		}
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password,
			@RequestParam(defaultValue = "false") boolean rememberMe, RedirectAttributes attributes,
			HttpServletResponse response, Model model) {
		if (userService.authenticateUser(username, password)) {
			if (!rememberMe) {
				userService.rememberMe(username, response);
				System.out.println("Adding cookies");
			}
			return "redirect:/welcome?username=" + username;
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}

	private String getRememberMeCookieValue(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("rememberMe".equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
