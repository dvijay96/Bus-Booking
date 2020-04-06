package com.kentravels.app.service;

import java.util.List;

import com.kentravels.app.entity.User;

public interface AdminService extends BusService,RouteService {

	public void addUser(User user);
	
	public void deleteUser(int id);
	
	public User updateUserRole(String role,int id);
	
	public User getUser(int id);

	public List<User> getAllUsers();
	
	public String resetUserPassword(int id);

}
