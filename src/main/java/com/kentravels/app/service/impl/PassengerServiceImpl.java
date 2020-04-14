package com.kentravels.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.dto.PassengerDto;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Passenger;
import com.kentravels.app.entity.Ticket;
import com.kentravels.app.repository.PassengerRepo;
import com.kentravels.app.service.BusService;
import com.kentravels.app.service.PassengerService;
import com.kentravels.app.service.TicketService;
import com.kentravels.app.service.UserService;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepo repo;

	@Autowired
	private TicketService ticketService;

	@Autowired
	private BusService busService;

	@Autowired
	private UserService userService;

	@Override
	public String addPassenger(PassengerDto p, String user) {
		try {
			Bus bus = busService.getBus(p.getBusNo()).get();

			Ticket ticket = ticketService.generateTicket(bus, p.getSeats());

			Passenger passenger = new Passenger();

			passenger.setPassengerName(p.getName());
			passenger.setAge(p.getAge());
			passenger.setGender(p.getGender());
			passenger.setEmail(p.getEmail());
			passenger.setMobileNo(p.getMobileNo());
			passenger.getBuses().add(bus);
			passenger.getTickets().add(ticket);

			String passAdd = busService.addPassenger(passenger, bus.getBusId(), p.getSeats());

			userService.addBookings(ticket, user);

			return passAdd + "with ticket " + ticket.toString();
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}

	}

	@Override
	public String deletePassenger(int id) {
		try {
			Passenger p = repo.findById(id).get();
			repo.delete(p);
			return "passenger " + id + " deleted";
		} catch (Exception e) {
			return "passenger not found \n" + e.getLocalizedMessage();
		}
	}

	@Override
	public List<Passenger> viewPassengers() {
		return repo.findAll();
	}

	@Override
	public Passenger findPassenger(int ticketId) {
		return repo.findByTickets(ticketId);
	}

}
