package com.kentravels.app.service;

import java.util.Set;

import com.kentravels.app.dto.Customer;
import com.kentravels.app.entity.Ticket;
import com.kentravels.app.entity.User;

public interface UserService {

	public String addUser(Customer customer);

	public void addBookings(Ticket ticket, String user);

	public Set<Ticket> viewBookings(String user);

	public void updateUser(User user);

	public void removeBooking(Ticket ticket,String user);

}
