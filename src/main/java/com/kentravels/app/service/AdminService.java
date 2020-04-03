package com.kentravels.app.service;

import java.util.List;

import com.kentravels.app.entity.User;

public interface AdminService {

	public void addUser(User user);

	public List<User> getAllUsers();

}
