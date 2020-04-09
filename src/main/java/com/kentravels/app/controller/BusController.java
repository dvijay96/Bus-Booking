package com.kentravels.app.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.kentravels.app.dto.BusSearch;
import com.kentravels.app.entity.Bus;
import com.kentravels.app.service.BusService;

@RestController
@RequestMapping("/secured/api")
@PreAuthorize("hasAnyRole('ADMIN')")
public class BusController {

	@Autowired
	private BusService service;

	@PostMapping("/bus/add")
	public void addBus(@RequestBody BusInfo bus) {
		service.addBus(bus);
	}

	@DeleteMapping("/bus/delete")
	public String deleteBus(int id) {
		return service.deleteBus(id);
	}

	@PutMapping("/bus/update")
	public String updateBus(Bus bus) {
		return service.updateBus(bus);
	}

	@GetMapping("/bus/get/{id}")
	public ResponseEntity<?> getBus(@PathVariable int id) {
		return new ResponseEntity<>(service.getBus(id), HttpStatus.FOUND);
	}

	@GetMapping("/bus/all")
	public List<Bus> viewAllBuses() {
		return service.viewAllBuses();
	}

	@GetMapping("/search")
	public List<BusInfo> searchBus(@RequestBody BusSearch search) {
		List<BusInfo> buses = new ArrayList<>();
		for (Bus b : service.searchBuses(search)) {
			BusInfo bus = new BusInfo();
			bus.setBusId(b.getBusId());
			bus.setName(b.getName());
			bus.setType(b.getType());
			bus.setArrivalTime(b.getArrivalTime());
			bus.setDepartureTime(b.getDepartureTime());
			bus.setSeats(b.getAvailableSeats());
			bus.setFare(b.getFare());
			buses.add(bus);
		}
		return buses;
	}

	@PutMapping("/bus/add_route")
	public String addBusRoute(@RequestParam String origin, @RequestParam String destination, @RequestParam int id) {
		return service.addBusRoute(origin, destination, id);
	}
//	protected BusController() {
//		service.deleteBus(new Date(System.currentTimeMillis()));
//	}
}
