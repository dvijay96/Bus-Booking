package com.kentravels.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Bus;
import com.kentravels.app.repository.BusRepo;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepo repo;

	@Override
	public void addBus(Bus bus) {
		repo.save(bus);
	}

}
