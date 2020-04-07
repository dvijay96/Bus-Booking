package com.kentravels.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Passenger;
import com.kentravels.app.repository.PassengerRepo;
import com.kentravels.app.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepo repo;
	
	@Override
	public int addPassenger(Passenger passenger) {
		return 0;
	}

	@Override
	public String deletePassenger(int id) {
		try {
			Passenger p=repo.findById(id).get();
			repo.delete(p);
			return "passenger "+id+" deleted";
		}
		catch(Exception e) {
			return "passenger not found \n"+e.getLocalizedMessage();
		}
	}

	@Override
	public List<Passenger> viewPassengers() {
		return repo.findAll();
	}

}
