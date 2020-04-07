package com.kentravels.app.service;

import java.util.List;

import com.kentravels.app.entity.Route;

public interface RouteService {

	public String addRoute(Route route);

	public String deleteRoute(int id);

	public Route getRoute(String origin, String destination);

	public List<Route> viewRoutes();

	public String updateRoute(Route route);

}
