package com.kentravels.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

}
