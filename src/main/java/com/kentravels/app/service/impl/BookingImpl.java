package com.kentravels.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kentravels.app.entity.Ticket;
import com.kentravels.app.service.BookingService;
import com.kentravels.app.service.BusService;

public class BookingImpl implements BookingService {

	@Autowired
	private BusService bus;
	
	@Override
	public Ticket book() {
		// TODO Auto-generated method stub
		return null;
	}

}
