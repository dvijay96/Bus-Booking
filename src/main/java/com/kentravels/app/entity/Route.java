package com.kentravels.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq")
	@SequenceGenerator(name = "route_seq", initialValue = 100, allocationSize = 1)
	private int routeId;

	private String originCity;

	private String destinationCity;

	private int distance;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "route_bus", joinColumns = @JoinColumn(name = "route_id"), inverseJoinColumns = @JoinColumn(name = "bus_id"))
//	private Set<Bus> buses;

//	public Set<Bus> getBuses() {
//		return buses;
//	}
//
//	public void setBuses(Set<Bus> buses) {
//		this.buses = buses;
//	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
