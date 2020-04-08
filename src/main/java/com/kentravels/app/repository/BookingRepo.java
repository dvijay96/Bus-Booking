package com.kentravels.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.BookedBuses;

@Repository
public interface BookingRepo extends JpaRepository<BookedBuses, Integer> {

	
}
