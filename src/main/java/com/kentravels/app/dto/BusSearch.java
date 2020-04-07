package com.kentravels.app.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class BusSearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4292301494991897454L;

	private String origin;

	private String destination;

	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private Date date;

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

}
