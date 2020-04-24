package com.example.parking.dao;


import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.util.Pin;

import java.util.ArrayList;
import java.util.List;

public interface ParkingRequestDAO {


    ParkingRequest find(ParkingRequest newRequest);


    void save(ParkingRequest entity);


    void delete(ParkingRequest entity);


    List<ParkingRequest> findAll();
}
