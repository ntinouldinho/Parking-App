package com.example.library.memorydao;

import com.example.library.dao.ParkingRequestDAO;
import com.example.library.domain.Rating;
import com.example.library.domain.User;
import com.example.library.domain.ParkingRequest
import com.example.library.domain.Vehicle;

import java.util.ArrayList;

public class ParkingRequestDAOMemory implements ParkingRequestDAO{
    protected static ArrayList<User> users = new ArrayList<User>();
}
