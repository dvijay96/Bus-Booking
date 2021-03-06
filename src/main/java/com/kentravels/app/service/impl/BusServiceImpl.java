package com.kentravels.app.service.impl;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.dto.BusInfo;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Passenger;
import com.kentravels.app.entity.Route;
import com.kentravels.app.repository.BusRepo;
import com.kentravels.app.service.BusService;
import com.kentravels.app.service.PassengerService;
import com.kentravels.app.service.RouteService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepo repo;

	@Autowired
	private RouteService routeService;

	@Autowired
	private PassengerService pService;

	@Override
	public String addBus(BusInfo bus) {

		Bus newBus = new Bus();

		newBus.setType(bus.getType());
		newBus.setName(bus.getName());
		newBus.setDate(bus.getDate());
		newBus.setArrivalTime(bus.getArrivalTime());
		newBus.setDepartureTime(bus.getDepartureTime());
		newBus.setSeats(bus.getAvailable_Seats());
		newBus.setFare(bus.getFare());

		repo.save(newBus);
		
		return "Bus Added";
	}

	@Override
	public String deleteBus(int id) {
		try {
			Bus bus = getBus(id).get();
			repo.delete(bus);
			return "bus no." + id + " deleted";
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@Override
	public String updateBusTime(String arrival, String departure, int id) {
		try {
			Bus bus = getBus(id).get();
			SimpleDateFormat df = new SimpleDateFormat("HH:mm");
			Date arrivalTime = df.parse(arrival);
			Date departureTime = df.parse(departure);

			bus.setArrivalTime(arrivalTime);
			bus.setDepartureTime(departureTime);

			repo.save(bus);
			return "bus's time updated";
			
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@Override
	public List<Bus> viewAllBuses() {
		return repo.findAll();
	}

	@Override
	public Optional<Bus> getBus(int id) {
		return repo.findById(id);
	}

	@Override
	public void deleteBus(Date date) {
		repo.deleteBuses(date);

	}

	@Override
	public List<Bus> searchBuses(String origin, String destination, String date) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date d = df.parse(date);
		Time t = new Time(System.currentTimeMillis());
		return repo.searchBuses(origin, destination, d, t);
	}

	@Override
	public String addBusRoute(String origin, String destination, int busId) {
		try {

			Route route = routeService.getRoute(origin, destination);
			if (route == null) {
				return "No such route exists";
			}
			Bus bus = repo.findById(busId).get();
			bus.setRoute(route);
			repo.save(bus);
			return "Bus_no: " + busId + " added for " + route.getOriginCity() + " --> " + route.getDestinationCity();
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@Override
	public String addPassenger(Passenger passenger, int busId, int seats) {
		try {
			Bus bus = getBus(busId).get();
			bus.getPassengers().add(passenger);
			bus.setSeats(bus.getSeats() - seats);

			repo.save(bus);

			return "passenger added to bus: " + busId + "\n Route: " + bus.getRoute().getOriginCity() + " ->"
					+ bus.getRoute().getDestinationCity();
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@Override
	public Set<Passenger> viewPassengers(int id) {
		Bus bus = getBus(id).get();
		return bus.getPassengers();
	}

	@Override
	public void updateBus(Bus bus) {

		repo.save(bus);
	}

}
