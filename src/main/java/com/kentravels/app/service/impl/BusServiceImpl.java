package com.kentravels.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Bus;
import com.kentravels.app.repository.BusRepo;
import com.kentravels.app.service.BusService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepo repo;

	@Override
	public void addBus(Bus bus) {
		repo.save(bus);
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

}
