package com.kentravels.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Role;
import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRepo userRepo;

	@Override
	public void addUser(User user) {

		String userRole = user.getRole().getRole();
		Role role = roleService.findRole(userRole);

		if (role != null) {
			user.setRole(role);
			roleService.saveRole(role);
		}

		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);

	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

}
