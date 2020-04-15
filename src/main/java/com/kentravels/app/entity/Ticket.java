package com.kentravels.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "total_fare")
	private int totalFare;

	@Column(name = "Bus_Name")
	private String busName;

	@Temporal(TemporalType.TIME)
	private Date departure;

	@Temporal(TemporalType.TIME)
	private Date arrival;

	private String origin;

	private String destination;

	@OneToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	/*
	 * @OneToOne(cascade=CascadeType.MERGE) // @JoinColumn(name = "passenger_id")
	 * private Passenger passenger;
	 */

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * public Passenger getPassenger() { return passenger; }
	 * 
	 * public void setPassenger(Passenger passenger) { this.passenger = passenger; }
	 */

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

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

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Date getDate() {
		return date;
	}

	public int getFare() {
		return totalFare;
	}

	public void setFare(int totalFare) {
		this.totalFare = totalFare;
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

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	@Override
	public String toString() {
		return "Ticket ==> [ticketId=" + ticketId + "\n date=" + date + "\n totalFare=" + totalFare + "\n busName="
				+ busName + "\n departure=" + departure + "\n arrival=" + arrival + "\n origin=" + origin
				+ "\n destination=" + destination + "]";
	}

}
