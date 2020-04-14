package com.kentravels.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pass_seq")
	@SequenceGenerator(name = "pass_seq", initialValue = 200, allocationSize = 1)
	private int passengerId;

	private String passengerName;

	private int age;

	private String gender;

	@Column(nullable = true)
	private String email;

	@Column(precision = 10)
	private long mobileNo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "passenger")
	@JoinTable(name = "passenger_ticket", joinColumns = @JoinColumn(name = "passenger_id"), inverseJoinColumns = @JoinColumn(name = "ticket_id"))
	private Ticket ticket;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Ticket getTickets() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
