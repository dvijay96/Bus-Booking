package com.kentravels.app.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bus_seq")
	@SequenceGenerator(name = "bus_seq", initialValue = 500, allocationSize = 1)
	private int busId;

	private String type;

	private String name;

	@Column(name = "available_seats")
	private int seats;

	@Temporal(TemporalType.TIME)
	private Date arrivalTime;

	@Temporal(TemporalType.TIME)
	private Date departureTime;

	private int fare;

	@Temporal(TemporalType.DATE)
	private Date date;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name="route_id")
//	@JoinTable(name = "bus_route", joinColumns = @JoinColumn(name = "bus_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
	private Route route;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bus_passenger", joinColumns = @JoinColumn(name = "bus_id"), inverseJoinColumns = @JoinColumn(name = "passenger_id"))
	private Set<Passenger> passengers = new HashSet<>();

	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
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

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
