package com.kentravels.app.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.entity.Ticket;
import com.kentravels.app.service.UserService;

@RestController
@RequestMapping("/secured/api")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/my_bookings")
	public Set<Ticket> myBookings() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return service.viewBookings(auth.getName());
	}

}
