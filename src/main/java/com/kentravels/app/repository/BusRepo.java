package com.kentravels.app.repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.Bus;

@Repository
public interface BusRepo extends JpaRepository<Bus, Integer> {

	@Query("Delete from Bus b where b.date<:date")
	public void deleteBuses(Date date);

	@Query("from Bus b inner join Route r on b.route=r.routeId where b.date=:date and r.originCity=:origin and r.destinationCity=:destination and b.departureTime>:time")
	public List<Bus> searchBuses(String origin, String destination, Date date,Time time);
}
