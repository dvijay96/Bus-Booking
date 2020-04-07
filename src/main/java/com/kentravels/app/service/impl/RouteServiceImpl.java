package com.kentravels.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kentravels.app.entity.Route;
import com.kentravels.app.repository.RouteRepo;
import com.kentravels.app.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepo repo;

	@Override
	public String addRoute(Route route) {
		try {
			repo.save(route);
			return "route saved";
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@Override
	public Route getRoute(String origin, String destination) {
		return repo.findByCities(origin, destination);
	}

	@Override
	public String deleteRoute(int id) {
		try {
			Route route = repo.findById(id).get();
			repo.delete(route);
			return "route: " + route.getOriginCity() + " to " + route.getDestinationCity() + " removed";
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}

	@Override
	public List<Route> viewRoutes() {

		return repo.findAll();
	}

	@Override
	public String updateRoute(Route route) {

		try {
			repo.save(route);
			return "route updated";
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}
}
