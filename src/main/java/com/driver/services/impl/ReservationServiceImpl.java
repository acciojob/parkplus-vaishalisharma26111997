package com.driver.services.impl;

import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {

    	return null;
    }
	public User getUserById(Integer userId) {
		return userRepository3.findById(userId).get();
	}
	public void saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		reservationRepository3.save(reservation);
		
	}
	public ParkingLot findbyId(Integer parkingLotId) {
		return parkingLotRepository3.findById(parkingLotId).get();
	}
	public List<Spot> getAvailableSpotsByVehicleType(Integer parkingLotId,
			Integer numberOfWheels) {
		ParkingLot parkingLot = parkingLotRepository3.findById(parkingLotId).get();
	    if (parkingLot == null) {
	        throw new IllegalArgumentException("Parking lot not found");
	    }

	    List<Spot> availableSpots = new ArrayList<>();

	    // Iterate over the spots in the parking lot
	    for (Spot spot : parkingLot.getSpotList()) {
	        // Check if the spot's type is equal to or larger than the vehicle's type
	        if (check(spot.getSpotType(),numberOfWheels)) {
	            // Check if the spot is available
	            if (isSpotAvailable(spot)) {
	                availableSpots.add(spot);
	            }
	        }
	    }

	    return availableSpots;
	}
	private boolean isSpotAvailable(Spot spot) {
	    // Implement your logic to check if the spot is available
	    // For example, you could check if the spot is occupied or if it has any reservations during the requested time
	    // Return true if the spot is available, false otherwise
	    return !spot.isOccupied();
	}
	private boolean check(SpotType spotType,Integer numberOfWheels)
	{
		if(spotType.equals("TWO_WHEELER") && numberOfWheels<=2)
		{
			return true;
		}
		if(spotType.equals("FOUR_WHEELER") && numberOfWheels<=4)
		{
			return true;
		}
		return false;
	}
}
