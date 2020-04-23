package com.example.library.dao;
import com.example.library.domain.*;

public abstract class Initializer {

    protected abstract void eraseData();
    public abstract void prepareData();
    protected abstract ParkingRequestDAO getRequestDAO();
    protected abstract ParkingSpaceDAO getParkingDAO();
    protected abstract UserDAO getUserDAO();

}
