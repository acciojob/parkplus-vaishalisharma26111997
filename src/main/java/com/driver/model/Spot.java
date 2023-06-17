package com.driver.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="spot")
public class Spot {
	 @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 @Enumerated(EnumType.STRING)
	private SpotType spotType;
	@ManyToOne
	@JoinColumn
	private ParkingLot parkingLot;
	
	private List<Reservation> reservationList;
	public ParkingLot getParkingLot() {
		return parkingLot;
	}
	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	public List<Reservation> getReservationList() {
		return reservationList;
	}
	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SpotType getSpotType() {
		return spotType;
	}
	public void setSpotType(SpotType spotType) {
		this.spotType = spotType;
	}
	public int getPricePerHour() {
		return pricePerHour;
	}
	public void setPricePerHour(int pricePerHour) {
		this.pricePerHour = pricePerHour;
	}
	public boolean getOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	private int pricePerHour;
	private boolean occupied;

}
