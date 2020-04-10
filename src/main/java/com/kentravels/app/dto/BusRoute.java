package com.kentravels.app.dto;

import java.io.Serializable;

public class BusRoute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4292301494991897454L;

	private String origin;

	private String destination;

	private int busId;

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

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

}
