package com.kentravels.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.dto.Customer;
import com.kentravels.app.service.UserService;

@RestController
@RequestMapping("/")
public class PublicController {

	@Autowired
	private UserService service;

	@PostMapping("/user/register")
	public String addUser(@RequestBody Customer cust) {
		return service.addUser(cust);
	}
	
	@GetMapping("home")
	public String welcome() {
		return "<h1>wellcome to KenTraVels </h2>";
	}
}
