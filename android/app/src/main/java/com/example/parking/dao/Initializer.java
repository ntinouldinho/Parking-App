package com.example.parking.dao;

import com.example.parking.domain.*;

public abstract class Initializer {

    protected abstract void eraseData();
    public abstract void prepareData();
    protected abstract ParkingRequestDAO getRequestDAO();
    protected abstract ParkingSpaceDAO getParkingDAO();
    protected abstract UserDAO getUserDAO();

}
