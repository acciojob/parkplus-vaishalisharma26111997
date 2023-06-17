package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table
public class Payment {

	private int id;
	private boolean paymentCompleted;
	 @Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	private Reservation reservation;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int id, boolean paymentCompleted, PaymentMode paymentMode, Reservation reservation) {
		super();
		this.id = id;
		this.paymentCompleted = paymentCompleted;
		this.paymentMode = paymentMode;
		this.reservation = reservation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isPaymentCompleted() {
		return paymentCompleted;
	}
	public void setPaymentCompleted(boolean paymentCompleted) {
		this.paymentCompleted = paymentCompleted;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
