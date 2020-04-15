package com.kentravels.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

	@Query("from Passenger p join Ticket t on p.ticket=t.ticketId where t.ticketId=:ticketId")
	public Passenger findByTicket(int ticketId);
}
