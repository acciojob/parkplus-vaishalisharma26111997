package com.driver.controllers;

import com.driver.model.ParkingLot;
import com.driver.model.Payment;
import com.driver.model.Reservation;
import com.driver.model.Spot;
import com.driver.model.User;
import com.driver.services.impl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationServiceImpl reservationService;
    @PostMapping("/reserveSpot")
    public Reservation reserveSpot(@RequestParam Integer userId, @RequestParam Integer parkingLotId, @RequestParam Integer timeInHours, @RequestParam Integer numberOfWheels) throws Exception{
        //Reserve a spot in the given parkingLot such that the total price is minimum. Note that the price per hour for each spot is different
        //Note that the vehicle can only be parked in a spot having a type equal to or larger than given vehicle
        //If parkingLot is not found, user is not found, or no spot is available, throw "Cannot make reservation" exception.

    	 ParkingLot parkingLot = reservationService.findbyId(parkingLotId);
    	    if (parkingLot == null) {
    	        throw new Exception("Parking lot not found");
    	    }

    	    // Check if the user exists
    	    User user = reservationService.getUserById(userId);
    	    if (user == null) {
    	        throw new Exception("User not found");
    	    }

    	    // Find available spots that match the vehicle's type
    	    List<Spot> availableSpots = reservationService.getAvailableSpotsByVehicleType(parkingLotId, numberOfWheels);

    	    // Sort the available spots based on the price per hour
    	    availableSpots.sort(Comparator.comparingDouble(Spot::getPricePerHour));

    	    // Check if any spot is available
    	    if (availableSpots.isEmpty()) {
    	        throw new Exception("No spot available for the given vehicle type");
    	    }

    	    // Reserve the spot with the lowest price per hour
    	    Spot reservedSpot = availableSpots.get(0);
    	    int totalPrice = reservedSpot.getPricePerHour() * timeInHours;
    	    reservedSpot.setPricePerHour(totalPrice);

    	    // Create and save the reservation
    	    Reservation reservation = new Reservation();
    	    reservation.setNumberOfHours(timeInHours);
    	    reservation.setSpot(reservedSpot);
    	    reservation.setUser(user);
    	    //reservation.setPayment(null);
    	    reservationService.saveReservation(reservation);

    	    return reservation;
    }
}
