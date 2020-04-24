package com.example.parking.memorydao;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingSpaceDAOMemory implements ParkingSpaceDAO {

    protected static ArrayList<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();

    public void save(ParkingSpace p){
        if(!parkingSpaces.contains(p)){
            parkingSpaces.add(p);
        }
    }

    public void delete(ParkingSpace p){
        parkingSpaces.remove(p);
    }

    public List<ParkingSpace> findAll(){
        return parkingSpaces;
    }


    public ParkingSpace find(ParkingSpace parking){
        for(ParkingSpace p: parkingSpaces){
            if(p.equals(parking)){
                return p;
            }
        }
        return null;
    }

}
