package com.driver.services.impl;

import com.driver.model.Payment;
import com.driver.model.PaymentMode;
import com.driver.repository.PaymentRepository;
import com.driver.repository.ReservationRepository;
import com.driver.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.driver.model.*;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    ReservationRepository reservationRepository2;
    @Autowired
    PaymentRepository paymentRepository2;

    @Override
    public Payment pay(Integer reservationId, int amountSent, String mode) throws Exception {

    	 Reservation reservation = reservationRepository2.findById(reservationId).get();
    	    if (reservation == null) {
    	        throw new IllegalArgumentException("Reservation not found");
    	    }

    	    // Check if the amount sent is less than the total price
    	    Payment totalPrice = reservation.getPayment();
    	    if (amountSent < Integer.BYTES) {
    	        throw new Exception("Insufficient Amount");
    	    }

    	    // Normalize the payment mode to lowercase
    	    String normalizedMode = mode.toLowerCase();

    	    // Check if the payment mode is valid
    	    if (!normalizedMode.equals("cash") && !normalizedMode.equals("card") && !normalizedMode.equals("upi")) {
    	        throw new Exception("Payment mode not detected");
    	    }

    	    // Process the payment using the PaymentService
    	   
    	    PaymentService paymentService=null;
			Payment payment = paymentService.pay(reservationId, amountSent, normalizedMode);
			 paymentRepository2.save(payment);
    	    // Return the payment object
    	    return  payment;
    }
}
