package com.kentravels.app.service;

import java.util.List;

import com.kentravels.app.entity.Passenger;

public interface PassengerService {

	public int addPassenger(Passenger passenger);

	public String deletePassenger(int id);

	public List<Passenger> viewPassengers();

}
