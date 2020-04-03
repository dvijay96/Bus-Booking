package com.kentravels.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Role;
import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleService roleService;

	@Override
	public void addUser(User user) {
		String userRole = user.getRole().getRole();
		Role role = roleService.findRole(userRole);

		if (role != null) {
			user.setRole(role);
			roleService.saveRole(role);
		}

		userRepo.save(user);

	}

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

}
