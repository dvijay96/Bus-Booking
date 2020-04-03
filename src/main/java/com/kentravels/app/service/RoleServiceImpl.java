package com.kentravels.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kentravels.app.entity.Role;
import com.kentravels.app.repository.RoleRepo;

public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	@Override
	public void saveRole(Role role) {

		roleRepo.save(role);
	}

}
