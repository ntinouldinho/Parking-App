package com.example.parking.memorydao;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.domain.ParkingSpace;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpaceDAOMemory implements ParkingSpaceDAO {

    protected static ArrayList<ParkingSpace> parkingSpaces = new ArrayList<ParkingSpace>();

    @Override
    public void save(ParkingSpace p){
        if(!parkingSpaces.contains(p)){
            parkingSpaces.add(p);
        }
    }

    @Override
    public void delete(ParkingSpace p){
        parkingSpaces.remove(p);
    }

    @Override
    public List<ParkingSpace> findAll(){
        return new ArrayList<ParkingSpace> (parkingSpaces);
    }

    @Override
    public ParkingSpace find(ParkingSpace parking){
        for(ParkingSpace p: parkingSpaces){
            if(p.equals(parking)){
                return p;
            }
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public List <ParkingSpace> findAllAvailable(){
        List<ParkingSpace> allps = findAll();
        List<ParkingSpace> avps = new ArrayList<ParkingSpace>();
        for(ParkingSpace p: allps){
            if(p.getAvailability()){
                avps.add(p);
            }
        }
        return avps;
    }



}
