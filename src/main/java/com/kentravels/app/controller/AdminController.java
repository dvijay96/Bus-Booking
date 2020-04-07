package com.kentravels.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.entity.User;
import com.kentravels.app.service.AdminService;

@RestController
@RequestMapping("secured/admin")
public class AdminController {

	@Autowired
	private AdminService admin;

	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {

		admin.addUser(user);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		admin.deleteUser(id);
		return "user deleted";
	}

	@GetMapping("/user/get/{id}")
	public User getUser(@PathVariable int id) {
		return admin.getUser(id);
	}

	@PutMapping("/user/changeRole/{id}/{role}")
	public ResponseEntity<User> updateRole(@PathVariable String role, @PathVariable int id) {
		User user = admin.updateUserRole(role, id);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
	}

	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(admin.getAllUsers(), HttpStatus.FOUND);
	}

	@PutMapping("/user/passwordReset/{id}")
	public String resetPassword(@PathVariable int id) {
		return admin.resetUserPassword(id);
	}

}
