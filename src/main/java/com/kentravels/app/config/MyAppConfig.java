package com.kentravels.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kentravels.app.entity.User;

@Configuration
public class MyAppConfig {

	@Bean
	public User getUser() {
		return new User();
	}
}
