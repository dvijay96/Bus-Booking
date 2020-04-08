package com.kentravels.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kentravels.app.dto.BusSearch;
import com.kentravels.app.dto.Customer;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Role;
import com.kentravels.app.entity.Ticket;
import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;
import com.kentravels.app.service.RoleService;
import com.kentravels.app.service.RouteService;
import com.kentravels.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleService roleService;

	@Autowired
	private User user;

	@Autowired
	private RouteService routeService;

//	@Autowired
//	private TicketService ticket;

//	@Autowired
//	private BCryptPasswordEncoder encoder;

	@Override
	public String addUser(Customer customer) {

		try {
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
	public List<Bus> searchBuses(BusSearch search) {
		return null;
	}

	@Override
	public Ticket bookTicket() {
		// TODO Auto-generated method stub
		return null;
	}

}
