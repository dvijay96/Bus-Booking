package com.kentravels.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.service.UserService;

@RestController
@RequestMapping("/secured/api")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/book/Ticket")
	public ResponseEntity<?> bookTicket() {
		return null;
	}

}
