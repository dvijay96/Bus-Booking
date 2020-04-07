package com.kentravels.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.dto.BusSearch;
import com.kentravels.app.service.UserService;

@RestController
@RequestMapping("secured/customer")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/book/Ticket")
	public ResponseEntity<?> bookTicket() {
		return null;
	}

	@GetMapping("/search/bookings")
	public ResponseEntity<?> checkBookings(@RequestBody BusSearch booking) {
		return null;
	}

}
