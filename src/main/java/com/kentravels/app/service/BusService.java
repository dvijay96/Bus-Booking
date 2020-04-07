package com.kentravels.app.service;

import java.util.List;
import java.util.Optional;

import com.kentravels.app.entity.Bus;

public interface BusService {

	public void addBus(Bus bus);
	
	public String deleteBus(int id);
	
	public String updateBus(Bus bus);
	
	public Optional<Bus> getBus(int id);
	
	public List<Bus> viewAllBuses(); 
}
