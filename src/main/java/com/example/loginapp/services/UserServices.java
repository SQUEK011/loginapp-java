package com.example.loginapp.services;

import com.example.loginapp.models.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserServices {

	User findByUsername(String username);

	boolean authenticateUser(String username, String password);

	public boolean isUserAuthenticated(String username);

	// For Persistent Login
	void rememberMe(String username, HttpServletResponse response);

	void forgetMe(HttpServletResponse response);

	String getRememberMeCookieValue(HttpServletRequest request);
}
