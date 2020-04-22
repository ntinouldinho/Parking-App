package com.example.library.dao;

import com.example.library.domain.ParkingRequest;
import com.example.library.domain.ParkingSpace;
import com.example.library.util.Pin;

import java.util.ArrayList;

public interface ParkingRequestDAO {


    ArrayList<ParkingSpace> findParking(ArrayList<ParkingSpace> parkingSpaces, int difference);


    boolean validateParking(Pin pin);
}
