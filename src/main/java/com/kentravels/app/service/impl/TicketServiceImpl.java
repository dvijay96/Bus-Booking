package com.kentravels.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Passenger;
import com.kentravels.app.entity.Ticket;
import com.kentravels.app.repository.TicketRepo;
import com.kentravels.app.service.BusService;
import com.kentravels.app.service.PassengerService;
import com.kentravels.app.service.TicketService;
import com.kentravels.app.service.UserService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepo repo;

	@Autowired
	private PassengerService pService;

	@Autowired
	private BusService busService;

	@Autowired
	private UserService userService;

	@Override
	public Ticket generateTicket(Bus bus, int seats) {

		Ticket ticket = new Ticket();

		ticket.setBusName(bus.getName());
		ticket.setBus(bus);
		ticket.setDate(bus.getDate());
		ticket.setOrigin(bus.getRoute().getOriginCity());
		ticket.setDestination(bus.getRoute().getDestinationCity());
		ticket.setDeparture(bus.getDepartureTime());
		ticket.setArrival(bus.getArrivalTime());
		ticket.setFare(seats * bus.getFare());

		return ticket;
	}

	@Override
	public String deleteTicket(int id) {
		try {

			Ticket ticket = repo.findById(id).get();

			Passenger passenger = pService.findPassenger(id);

			Bus bus = ticket.getBus();

			if (!bus.getPassengers().contains(passenger)) {
				return "Passenger doesn't exists";
			}
			bus.getPassengers().remove(passenger);
			bus.setSeats(bus.getSeats() + (ticket.getFare() / bus.getFare()));
			busService.updateBus(bus);

			pService.deletePassenger(passenger.getPassengerId());
			
			

			return "ticket cancelled";

		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

}
