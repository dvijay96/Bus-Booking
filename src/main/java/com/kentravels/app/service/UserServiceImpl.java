package com.kentravels.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public void addUser(User user) {
		userRepo.save(user);

	}

}
