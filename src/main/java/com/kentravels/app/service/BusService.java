package com.kentravels.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.kentravels.app.dto.BusInfo;
import com.kentravels.app.dto.BusSearch;
import com.kentravels.app.entity.Bus;

public interface BusService {

	public void addBus(BusInfo bus);
	
	public String deleteBus(int id);
	
	public String updateBus(Bus bus);
	
	public Optional<Bus> getBus(int id);
	
	public List<Bus> viewAllBuses(); 
	
	public void deleteBus(Date date);
	
	public List<Bus> searchBuses(BusSearch bus);
}
