package com.kentravels.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.kentravels.app.dto.BusInfo;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Passenger;

public interface BusService {

	public String addBus(BusInfo bus);

	public String deleteBus(int id);
	
	public void updateBus(Bus bus);

	public String updateBusTime(String arrival,String departure,int id);

	public Optional<Bus> getBus(int id);

	public List<Bus> viewAllBuses();

	public void deleteBus(Date date);

	public List<Bus> searchBuses(String origin, String destination, String date) throws Exception;

	public String addBusRoute(String origin, String destination, int busId);

	public String addPassenger(Passenger passenger, int busId, int seats);
	
	public Set<Passenger> viewPassengers(int id);

}
