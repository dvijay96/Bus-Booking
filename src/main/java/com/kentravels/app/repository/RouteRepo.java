package com.kentravels.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kentravels.app.entity.Route;

@Repository
public interface RouteRepo extends JpaRepository<Route, Integer> {

	@Query("From Route where orginCity=:origin and destinationCity=:destination")
	public Route findByCities(String origin, String destination);
}
