package com.kentravels.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.dto.Customer;
import com.kentravels.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/user/register")
	public String registerUser(@RequestBody Customer customer) {
		service.addUser(customer);
		return "user registered successfuly";
	}
}
