package com.example.loginapp.services;

import org.springframework.stereotype.Service;

import com.example.loginapp.models.User;
import com.example.loginapp.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserServicesImpl implements UserServices {

	private final UserRepository userRepository;

	public UserServicesImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean authenticateUser(String username, String password) {
		User user = findByUsername(username);
		return user != null && user.getPassword().equals(password);
	}

	@Override
	public boolean isUserAuthenticated(String username) {
		if (username != null) {
			User user = findByUsername(username);
			return user != null;
		} else {
			return false;
		}

	}

	@Override
	public void rememberMe(String username, HttpServletResponse response) {
		Cookie cookie = new Cookie("rememberMe", username);
		cookie.setMaxAge(604800); // One week in seconds
		response.addCookie(cookie);
	}

	@Override
	public void forgetMe(HttpServletResponse response) {
		Cookie cookie = new Cookie("rememberMe", null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

	@Override
	public String getRememberMeCookieValue(HttpServletRequest request) {
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
