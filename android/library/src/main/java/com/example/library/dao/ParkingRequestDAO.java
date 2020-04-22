package com.example.library.dao;

import com.example.library.domain.ParkingRequest;
import com.example.library.domain.ParkingSpace;
import com.example.library.util.Pin;

import java.util.ArrayList;
import java.util.List;

public interface ParkingRequestDAO {


    ParkingRequest find(int borrowerNo);


    void save(ParkingRequest entity);


    void delete(ParkingRequest entity);


    List<ParkingRequest> findAll();
}
