package com.kentravels.app.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kentravels.app.dto.Customer;
import com.kentravels.app.entity.Role;
import com.kentravels.app.entity.Ticket;
import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;
import com.kentravels.app.service.BusService;
import com.kentravels.app.service.RoleService;
import com.kentravels.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleService roleService;

	@Autowired
	private BusService busService;

	@Override
	public String addUser(Customer customer) {

		try {
			User user = new User();
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
			return customer.getFirstName() + " saved";
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@Override
	public void addBookings(Ticket ticket, String user) {
		User u = userRepo.findByUsername(user);
		u.getBookings().add(ticket);
		userRepo.save(u);
	}

	@Override
	public Set<Ticket> viewBookings(int id) {

		User user = userRepo.findById(id).get();
		return user.getBookings();
	}

}
