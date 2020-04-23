package com.example.library.memorydao;

import com.example.library.dao.Initializer;
import com.example.library.dao.ParkingRequestDAO;
import com.example.library.dao.ParkingSpaceDAO;
import com.example.library.dao.UserDAO;
import com.example.library.domain.ParkingRequest;
import com.example.library.domain.ParkingSpace;
import com.example.library.domain.User;

import java.util.List;

public class MemoryInitializer extends Initializer {

    @Override
    protected void eraseData() {
        List<User> users = getUserDAO().findAll();
        for(User user : users) {
            getUserDAO().delete(user);
        }

        List<ParkingRequest> parkingRequests = getRequestDAO().findAll();
        for(ParkingRequest parkingRequest : parkingRequests) {
            getRequestDAO().delete(parkingRequest);
        }

        List<ParkingSpace> parkingSpaces = getParkingDAO().findAll();
        for(ParkingSpace parkingSpace : parkingSpaces) {
            getParkingDAO().delete(parkingSpace);
        }
    }

    @Override
    public void prepareData(){
        eraseData();


    }
    @Override
    protected ParkingRequestDAO getRequestDAO() {
        return new ParkingRequestDAOMemory();
    }

    @Override
    protected ParkingSpaceDAO getParkingDAO() {
        return new ParkingSpaceDAOMemory();
    }

    @Override
    protected UserDAO getUserDAO() {
        return new UserDAOMemory();
    }

}
