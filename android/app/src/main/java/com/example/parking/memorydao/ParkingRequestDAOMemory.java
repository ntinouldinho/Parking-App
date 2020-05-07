package com.example.parking.memorydao;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.domain.Rating;
import com.example.parking.domain.User;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingRequestDAOMemory implements ParkingRequestDAO{
    protected static ArrayList<ParkingRequest> requests = new ArrayList<ParkingRequest>();

    public void delete(ParkingRequest request) {
        requests.remove(request);
    }

    public List<ParkingRequest> findAll() {
        return new ArrayList<ParkingRequest>(requests);
    }


    public void save(ParkingRequest request) {
        if (! requests.contains(request)) {
            requests.add(request);
        }
    }


    public ParkingRequest find(ParkingRequest newRequest) {
        for(ParkingRequest request : requests) {
            if (request.equals(newRequest)) {
                return request;
            }
        }
        return null;
    }
}
