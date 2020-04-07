package com.kentravels.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.Bookings;

@Repository
public interface BookingRepo extends JpaRepository<Bookings, Integer> {

	
}
