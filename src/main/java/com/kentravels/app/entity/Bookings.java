package com.kentravels.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Bookings {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rev_seq")
	@SequenceGenerator(name = "res_seq", initialValue = 50, allocationSize = 10)
	private int bookingId;

	@JsonFormat(shape=Shape.STRING,pattern="dd/MM/yyyy")
	private Date date;
	
	
	private Route route;
	
}
