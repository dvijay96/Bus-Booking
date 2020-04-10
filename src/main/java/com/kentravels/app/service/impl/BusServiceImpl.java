package com.kentravels.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.dto.BusInfo;
import com.kentravels.app.dto.BusSearch;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Route;
import com.kentravels.app.repository.BusRepo;
import com.kentravels.app.service.BusService;
import com.kentravels.app.service.RouteService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepo repo;

	@Autowired
	private RouteService routeService;


	public BusServiceImpl() {
		super();
		repo.deleteBuses(new Date(System.currentTimeMillis()));
	}

	@Override
	public void addBus(BusInfo bus) {

		Bus newBus = new Bus();
		newBus.setType(bus.getType());
		newBus.setName(bus.getName());
		newBus.setDate(bus.getDate());
		newBus.setArrivalTime(bus.getArrivalTime());
		newBus.setDepartureTime(bus.getDepartureTime());
		newBus.setAvailableSeats(bus.getSeats());
		newBus.setFare(bus.getFare());
		repo.save(newBus);
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
	public String updateBus(Bus bus) {
		repo.save(bus);
		return "bus updated";
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
	public List<Bus> searchBuses(BusSearch bus) {
		return repo.searchBuses(bus.getOrigin(), bus.getDestination(), bus.getDate());
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

}
