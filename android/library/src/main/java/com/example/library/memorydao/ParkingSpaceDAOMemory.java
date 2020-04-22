package com.example.library.memorydao;

import com.example.library.dao.ParkingRequestDAO;
import com.example.library.dao.ParkingSpaceDAO;
import com.example.library.domain.ParkingSpace;
import com.example.library.domain.User;

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

    /**
    public ParkingSpace find(ParkingSpace parking){
        for(ParkingSpace p: parkingSpaces){
            if(p.getUsername().equals(username)){
                return username;
            }
        }
        return null;
    }
     */
}
