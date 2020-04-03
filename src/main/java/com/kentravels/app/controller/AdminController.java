package com.kentravels.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.entity.Role;
import com.kentravels.app.entity.User;
import com.kentravels.app.service.RoleService;
import com.kentravels.app.service.UserService;

@RestController
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		Role role=user.getRole();
		roleService.saveRole(role);
		userService.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}
}
