package com.kentravels.app.service;

import java.util.List;

import com.kentravels.app.dto.UserInfo;
import com.kentravels.app.entity.User;

public interface AdminService {

	public void addUser(User user);
	
	public void deleteUser(int id);
	
	public User updateUserRole(String role,int id);
	
	public UserInfo getUser(int id);

	public List<UserInfo> getAllUsers();
	
	public String resetUserPassword(int id);

}
