package com.kentravels.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.dto.PassengerDto;
import com.kentravels.app.service.PassengerService;
import com.kentravels.app.service.TicketService;

@RestController
@RequestMapping("/secured/api")
public class BookingContoller {

	@Autowired
	private PassengerService service;

	@Autowired
	private TicketService ticketService;

	@PostMapping("/book/ticket")
	public String bookBus(@RequestBody PassengerDto passenger) {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String user=auth.getName();
			return service.addPassenger(passenger,user);

		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@DeleteMapping("/cancel/ticket/{id}")
	public String cancel(@PathVariable int id) {
		return ticketService.deleteTicket(id);
	}
	
}
