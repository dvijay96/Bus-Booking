package com.kentravels.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kentravels.app.entity.Ticket;

@RestController
@RequestMapping("/secured/api")
public class BookingContoller {

	@PostMapping("/book")
	public ResponseEntity<Ticket> bookBus() {
		return null;
	}
}
