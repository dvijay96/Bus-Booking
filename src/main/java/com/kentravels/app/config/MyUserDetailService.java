package com.kentravels.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.User;
import com.kentravels.app.repository.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);

		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return new MyUserDetail(user);
	}

}
