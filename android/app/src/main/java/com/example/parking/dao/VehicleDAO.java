package com.example.parking.dao;

import com.example.parking.domain.Vehicle;

import java.util.List;

public interface VehicleDAO {
    void save(Vehicle v);

    void delete(Vehicle v);

    Vehicle find(String plate);

    List<Vehicle> findAll();

}
