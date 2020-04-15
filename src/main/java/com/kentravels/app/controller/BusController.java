package com.kentravels.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.dto.BusInfo;
import com.kentravels.app.dto.BusRoute;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.entity.Passenger;
import com.kentravels.app.service.BusService;

@RestController
@RequestMapping("/secured/api")
public class BusController {

	@Autowired
	private BusService service;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/bus/add")
	public void addBus(@RequestBody BusInfo bus) {
		service.addBus(bus);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/bus/delete/{id}")
	public String deleteBus(@PathVariable int id) {
		return service.deleteBus(id);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/bus/update")
	public String updateBus(Bus bus) {
		return service.updateBus(bus);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/bus/get/{id}")
	public ResponseEntity<?> getBus(@PathVariable int id) {
		return new ResponseEntity<>(service.getBus(id), HttpStatus.FOUND);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/bus/all")
	public List<BusInfo> viewAllBuses() {

		List<BusInfo> buses = new ArrayList<>();
		
		for (Bus b : service.viewAllBuses()) {
			BusInfo bus = new BusInfo();
			bus.setBusId(b.getBusId());
			bus.setName(b.getName());
			bus.setType(b.getType());
			bus.setArrivalTime(b.getArrivalTime());
			bus.setDepartureTime(b.getDepartureTime());
			bus.setAvailable_Seats(b.getSeats());
			bus.setFare(b.getFare());
			bus.setOrigin(b.getRoute().getOriginCity());
			bus.setDestination(b.getRoute().getDestinationCity());
			bus.setDate(b.getDate());
			
			buses.add(bus);
		}
		
		return buses;
	}

	@GetMapping("/bus/search")
	public Object searchBus(@RequestParam String origin, @RequestParam String destination, @RequestParam String date) {
		try {
			List<BusInfo> buses = new ArrayList<>();
			for (Bus b : service.searchBuses(origin, destination, date)) {
				BusInfo bus = new BusInfo();
				bus.setBusId(b.getBusId());
				bus.setName(b.getName());
				bus.setType(b.getType());
				bus.setArrivalTime(b.getArrivalTime());
				bus.setDepartureTime(b.getDepartureTime());
				bus.setAvailable_Seats(b.getSeats());
				bus.setFare(b.getFare());
				buses.add(bus);
			}
			return buses;
		} catch (Exception e) {
			return e.getLocalizedMessage();
		}

	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PutMapping("/bus/add_route")
	public String addBusRoute(@RequestBody BusRoute add) {
		return service.addBusRoute(add.getOrigin(), add.getDestination(), add.getBusId());
	}
	
	@GetMapping("/bus/passengers/{id}")
	public Set<Passenger> onBoardPassengers(@PathVariable int id){
		Bus bus=service.getBus(id).get();
		return bus.getPassengers();
	}
}
