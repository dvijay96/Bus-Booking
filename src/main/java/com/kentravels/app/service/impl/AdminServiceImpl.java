package com.kentravels.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Role;
import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;
import com.kentravels.app.service.AdminService;
import com.kentravels.app.service.RoleService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRepo userRepo;

	// Admin /User services

	@Override
	public void addUser(User user) {

		String userRole = user.getRole().getRole();
		Role role = roleService.findRole(userRole);

		if (role != null) {
			user.setRole(role);
			roleService.saveRole(role);
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);

	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(int id) {
		User user = userRepo.findById(id).get();
		userRepo.delete(user);
	}

	@Override
	public User updateUserRole(String role, int id) {
		User user = userRepo.findById(id).get();
		Role userRole = roleService.findRole(role);
		if (userRole == null) {
			userRole = new Role(role);
			roleService.saveRole(userRole);
		}
		user.setRole(userRole);
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User getUser(int id) {
		User user = userRepo.findById(id).get();
		return user;
	}

	@Override
	public String resetUserPassword(int id) {
		User user = getUser(id);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String newPass = encoder.encode(user.getFirstName() + "123");
		user.setPassword(newPass);
		userRepo.save(user);
		return "password reseted as user firstName+123";
	}

	// Route Services

//	
//	public String addRoute(Route route) {
//		return routeService.addRoute(route);
//	}
//
//	@Override
//	public Route getRoute(String origin, String destination) {
//		return routeService.getRoute(origin, destination);
//	}
//
//	@Override
//	public String deleteRoute(int id) {
//		return routeService.deleteRoute(id);
//	}
//
//	// Bus Services
//
//	@Override
//	public void addBus(Bus bus) {
//		busService.addBus(bus);
//	}
//
//	@Override
//	public String deleteBus(int id) {
//		return busService.deleteBus(id);
//	}
//
//	@Override
//	public String updateBus(Bus bus) {
//		return busService.updateBus(bus);
//	}
//
//	@Override
//	public Optional<Bus> getBus(int id) {
//		return busService.getBus(id);
//	}
//
//	@Override
//	public List<Bus> viewAllBuses() {
//		return busService.viewAllBuses();
//	}

}
