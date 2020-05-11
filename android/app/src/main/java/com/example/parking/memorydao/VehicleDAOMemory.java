package com.example.parking.memorydao;

import com.example.parking.dao.VehicleDAO;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VehicleDAOMemory implements VehicleDAO {

    protected static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    @Override
    public void save(Vehicle v) {
        vehicles.add(v);
    }

    @Override
    public void delete(Vehicle v) {
        vehicles.remove(v);
    }

    @Override
    public Vehicle find(String plate) {
        for(Vehicle v : vehicles)
            if(v.getPlate() == plate)
                return v;

        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        ArrayList<Vehicle> vs = new ArrayList<Vehicle>();
        vs.addAll(vehicles);
        return vs;
    }

//    @Override
//    public List<Vehicle> findByUser(String username) {
//
//        if (username != null) {
//            List<Vehicle> vs = findAll();
//            for (Vehicle v : vs) {
//                Set<User> u = v.getPlate();
//                for (User u : users) {
//                    if (u.getUsername().equalsIgnoreCase(username)) {
//                        vs.add(v);
//                        break;
//                    }
//                }
//            }
//        }
//        return vs;
//    }
}
