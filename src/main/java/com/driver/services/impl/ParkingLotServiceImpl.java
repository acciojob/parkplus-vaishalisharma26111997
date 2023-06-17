package com.driver.services.impl;

import com.driver.model.SpotType;
import com.driver.model.ParkingLot;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.SpotRepository;
import com.driver.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    @Autowired
    ParkingLotRepository parkingLotRepository1;
    @Autowired
    SpotRepository spotRepository1;
    @Override
    public ParkingLot addParkingLot(String name, String address) {
          ParkingLot parkingLot=new ParkingLot();
          parkingLot.setName(name);
          parkingLot.setAddress(address);
          parkingLot.setSpotList(null);
          parkingLotRepository1.save(parkingLot);
          return parkingLot;     
    }

    @Override
    public Spot addSpot(int parkingLotId, Integer numberOfWheels, Integer pricePerHour) {

    }

    @Override
    public void deleteSpot(int spotId) {
       
    }

    @Override
    public Spot updateSpot(int parkingLotId, int spotId, int pricePerHour) {

    }

    @Override
    public void deleteParkingLot(int parkingLotId) {
    	parkingLotRepository1.deleteById(parkingLotId);
    }
}
