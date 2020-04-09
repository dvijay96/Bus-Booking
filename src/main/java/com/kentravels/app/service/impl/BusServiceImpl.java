package com.kentravels.app.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.dto.BusInfo;
import com.kentravels.app.dto.BusSearch;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.repository.BusRepo;
import com.kentravels.app.service.BusService;
import com.kentravels.app.service.RouteService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepo repo;

	@Autowired
	private RouteService routeService;

	@Autowired
	private Bus bus;

	@Override
	public void addBus(BusInfo bus) {
		this.bus.setType(bus.getType());
		this.bus.setName(bus.getName());
		this.bus.setDate(bus.getDate());
		this.bus.setArrivalTime(bus.getArrivalTime());
		this.bus.setDepartureTime(bus.getDepartureTime());
		this.bus.setAvailableSeats(bus.getSeats());
		this.bus.setFare(bus.getFare());
		repo.save(this.bus);
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

}
