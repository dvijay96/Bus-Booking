package com.kentravels.app.service;

import java.util.List;

import com.kentravels.app.dto.BusSearch;
import com.kentravels.app.dto.Customer;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Ticket;

public interface UserService {

	public String addUser(Customer customer);
	
	public List<Bus> searchBuses(BusSearch search);
	
	public Ticket bookTicket();

}
