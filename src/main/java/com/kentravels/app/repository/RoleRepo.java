package com.kentravels.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.Role;

@Repository
@Transactional
public interface RoleRepo extends JpaRepository<Role, Integer> {

	@Query("From Role where role=:role")
	public Role findByRole(String role); 
}
