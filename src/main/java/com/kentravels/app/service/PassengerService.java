package com.kentravels.app.service;

import java.util.List;

import com.kentravels.app.dto.PassengerDto;
import com.kentravels.app.entity.Passenger;

public interface PassengerService {

	public String addPassenger(PassengerDto passenger,String user);

	public String deletePassenger(int id);

	public List<Passenger> viewPassengers();
	
	public Passenger findPassenger(int ticketId);

}
