package com.kentravels.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {

	@Id
	private int ticketId;

	private int seats;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int totalFare;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "ticket_bus", joinColumns = @JoinColumn(name = "ticket_id"), inverseJoinColumns = @JoinColumn(name = "bus_id"))
	private Bus bus;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "ticket_route", joinColumns = @JoinColumn(name = "ticket_id"), inverseJoinColumns = @JoinColumn(name = "route_id"))
	private Route route;

//	@ManyToOne
//	private Set<Passenger> passengers;
//
//	public Set<Passenger> getPassengers() {
//		return passengers;
//	}
//
//	public void setPassengers(Set<Passenger> passengers) {
//		this.passengers = passengers;
//	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}
