package com.kentravels.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kentravels.app.dto.Customer;
import com.kentravels.app.entity.Role;
import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleService roleService;

	@Autowired
	private User user;

//	@Autowired
//	private BCryptPasswordEncoder encoder;

	@Override
	public void addUser(Customer customer) {

		user.setFirstName(customer.getFirstName());
		user.setLastName(customer.getLastName());
		user.setDOB(customer.getDOB());
		user.setUsername(customer.getUsername());

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(customer.getPassword()));
		user.setGender(customer.getGender());

		Role role = roleService.findRole("USER");
		if (role != null) {
			user.setRole(role);
			roleService.saveRole(role);
		} else {
			role = new Role("USER");
			user.setRole(role);
		}
		userRepo.save(user);
	}

//	@Override
//	public List<User> getAllUsers() {
//
//		return userRepo.findAll();
//	}

}
