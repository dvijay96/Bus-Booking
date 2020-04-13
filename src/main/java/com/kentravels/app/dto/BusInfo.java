package com.kentravels.app.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class BusInfo {

	private int busId;

	private String name;

	private String type;

	private int available_Seats;

	private Set<Integer> seat_map;

	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm", timezone = "Asia/Kolkata")
	private Date arrivalTime;

	@JsonFormat(shape = Shape.STRING, pattern = "HH:mm", timezone = "Asia/Kolkata")
	private Date departureTime;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Asia/Kolkata")
	private Date date;

	private int fare;

	private String origin;

	private String destination;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailable_Seats() {
		return available_Seats;
	}

	public void setAvailable_Seats(int available_Seats) {
		this.available_Seats = available_Seats;
	}

	public Set<Integer> getSeat_map() {
		return seat_map;
	}

	public void setSeat_map(Set<Integer> seat_map) {
		this.seat_map = seat_map;
	}

}
