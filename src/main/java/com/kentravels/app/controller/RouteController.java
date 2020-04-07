package com.kentravels.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.entity.Route;
import com.kentravels.app.service.RouteService;

@RestController
@RequestMapping("secured/admin")
public class RouteController {

	@Autowired
	private RouteService service;

	@PostMapping("/route/add")
	public String addRoute(@RequestBody Route route) {
		return service.addRoute(route);
	}

	@DeleteMapping("/route/delete/{id}")
	public String deleteRoute(@PathVariable int id) {
		return service.deleteRoute(id);
	}

	@GetMapping("/route/get/route")
	public ResponseEntity<Route> getRoute(@RequestParam String origin, @RequestParam String destination) {
		return new ResponseEntity<Route>(service.getRoute(origin, destination), HttpStatus.FOUND);
	}

	@GetMapping("/route/viewAll")
	public ResponseEntity<List<Route>> getAllRoutes() {
		return new ResponseEntity<List<Route>>(service.viewRoutes(), HttpStatus.FOUND);
	}

	@PutMapping("/route/change")
	public String changeRoute(@RequestBody Route route) {
		return service.updateRoute(route);
	}
}
