package com.example.parking.dao;


import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;

import java.util.ArrayList;
import java.util.List;

public interface UserDAO {

    void save(User u);

    void update(User u,String username);

    void delete(User u);

    User find(String username);

    ArrayList<User> findAll();

    User login(String username,String password);

    Vehicle findVehicle(String usernam,String plate);

    void updateVehicle(String username,Vehicle vehicle);
}
