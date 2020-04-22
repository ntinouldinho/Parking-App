package com.example.library.dao;

import com.example.library.domain.ParkingSpace;

import java.util.List;

public interface ParkingSpaceDAO {


    void save(ParkingSpace entity);


    void delete(ParkingSpace entity);


    List<ParkingSpace> findAll();
}
