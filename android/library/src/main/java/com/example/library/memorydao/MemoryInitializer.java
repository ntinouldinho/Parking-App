package com.example.library.memorydao;

import com.example.library.dao.Initializer;
import com.example.library.dao.ParkingRequestDAO;
import com.example.library.dao.ParkingSpaceDAO;
import com.example.library.dao.UserDAO;

public class MemoryInitializer extends Initializer {

    @Override
    protected void eraseData() {
    }


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
