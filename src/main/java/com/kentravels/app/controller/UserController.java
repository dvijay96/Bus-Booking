package com.kentravels.app.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.dto.TicketDto;
import com.kentravels.app.entity.Ticket;
import com.kentravels.app.service.UserService;

@RestController
@RequestMapping("/secured/api")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/my_bookings")
	public Set<TicketDto> myBookings() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Set<TicketDto> tickets = new HashSet<>();
		for (Ticket t : service.viewBookings(auth.getName())) {

			TicketDto ticket = new TicketDto();

			ticket.setTicketId(t.getTicketId());
			ticket.setBusName(t.getBusName());
			ticket.setSeats(t.getSeats());
			ticket.setDeparture(t.getDeparture());
			ticket.setArrival(t.getArrival());
			ticket.setTotalFare(t.getFare());
			ticket.setOrigin(t.getOrigin());
			ticket.setDestination(t.getDestination());
			ticket.setUser(t.getUser().getUsername());
			ticket.setDate(t.getDate());

			tickets.add(ticket);
		}
		return tickets;
	}

}
