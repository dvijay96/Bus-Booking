package com.kentravels.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured/api")
public class LoginLogoutController {

	@GetMapping("/login")
	public String login(HttpServletRequest req) {
		return req.getUserPrincipal().getName()+" logged in";
	}
	@GetMapping("logout")
	public String logout(HttpServletRequest req,HttpServletResponse res) {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		return auth.getName()+ " logged out";
	}
}
