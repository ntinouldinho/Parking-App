package com.example.library.memorydao;

import com.example.library.dao.UserDAO;
import com.example.library.domain.Rating;
import com.example.library.domain.User;
import com.example.library.domain.Vehicle;

import java.util.ArrayList;

public class UserDAOMemory implements UserDAO {

    protected static ArrayList<User> users = new ArrayList<User>();

    public ArrayList<Vehicle> addVehicle(Vehicle vehicle,ArrayList<Vehicle> vehicles){
        for(Vehicle currentVehicle:vehicles){
            if(currentVehicle.getPlate().equals(vehicle.getPlate())) return vehicles;
        }
        vehicles.add(vehicle);
        return vehicles;
    }

    public ArrayList<Vehicle> removeVehicle (Vehicle vehicle,ArrayList<Vehicle> vehicles){
        if(vehicles.size()>0){
            for (Vehicle v : vehicles) {
                if(vehicle.getPlate().equals(v.getPlate())){
                    vehicles.remove(v);
                    break;
                }
            }
        }
        return vehicles;
    }

    public double calculateRating(ArrayList<Rating> rating){
        int currentRating = 0;
        for(Rating rate: rating){
            currentRating+=rate.getRatingScore();
        }
        return currentRating/rating.size();
    }
}
