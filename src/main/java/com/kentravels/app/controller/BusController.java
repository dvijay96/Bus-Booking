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
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.entity.Bus;
import com.kentravels.app.service.BusService;

@RestController
public class BusController {

	@Autowired
	private BusService service;

	@PostMapping("/bus/add")
	public void addBus(Bus bus) {
		service.addBus(bus);
	}

	@DeleteMapping("bus/delete")
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
}
