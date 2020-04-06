package com.kentravels.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Role;
import com.kentravels.app.entity.Route;
import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RouteService routeService;

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

	// Bus Services

	@Override
	public void addBus(Bus bus) {

	}

	// Route Services

	@Override
	public String addRoute(Route route) {
		return routeService.addRoute(route);
	}

	@Override
	public Route getRoute(String origin, String destination) {
		return routeService.getRoute(origin, destination);
	}

	@Override
	public String deleteRoute(int id) {
		return routeService.deleteRoute(id);
	}

}
