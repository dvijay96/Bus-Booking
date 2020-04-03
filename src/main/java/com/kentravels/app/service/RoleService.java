package com.kentravels.app.service;

import com.kentravels.app.entity.Role;

public interface RoleService {

	public void saveRole(Role role);

	public Role findRole(String role);
}
