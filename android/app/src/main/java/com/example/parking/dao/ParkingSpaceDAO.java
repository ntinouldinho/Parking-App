package com.example.parking.dao;

import com.example.parking.domain.ParkingSpace;

import java.util.List;

public interface ParkingSpaceDAO {


    void save(ParkingSpace entity);


    void delete(ParkingSpace entity);


    List<ParkingSpace> findAll();

    ParkingSpace find(ParkingSpace parking);

    List <ParkingSpace> findAllAvailable();
}
