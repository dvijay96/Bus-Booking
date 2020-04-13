package com.kentravels.app.service;

import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Ticket;

public interface TicketService {

	public Ticket generateTicket(Bus bus,int seats);
	
	public String deleteTicket(int id);
}

