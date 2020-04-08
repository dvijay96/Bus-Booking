package com.kentravels.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.User;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}
