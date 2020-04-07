package com.kentravels.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.entity.Passenger;
import com.kentravels.app.service.PassengerService;

@RestController
public class PassengerController {

	@Autowired
	private PassengerService service;
	
	@PostMapping("/passenger/add")
	public String addPassenger(@RequestBody Passenger passenger) {
		service.addPassenger(passenger);
		return null;
	}
}
