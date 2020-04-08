package com.kentravels.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {

	@Id
	private int ticketId;

//	private int seats;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int fare;

	@Column(name = "Bus_Name")
	private String busName;

	@Temporal(TemporalType.TIME)
	private Date departure;

	@Temporal(TemporalType.TIME)
	private Date arrival;

	@OneToOne
	@JoinColumn(name = "passenger_id")
	private Passenger passenger;

	@OneToOne
	@JoinColumn(name = "route_id")
	private Route route;

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

//	public int getSeats() {
//		return seats;
//	}
//
//	public void setSeats(int seats) {
//		this.seats = seats;
//	}

	public Date getDate() {
		return date;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}
