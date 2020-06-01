package com.example.parking.dao;


import com.example.parking.domain.ParkingRequest;

import java.util.List;

public interface ParkingRequestDAO {


    ParkingRequest find(ParkingRequest newRequest);


    void save(ParkingRequest entity);


    void delete(ParkingRequest entity);


    List<ParkingRequest> findAll();
}
