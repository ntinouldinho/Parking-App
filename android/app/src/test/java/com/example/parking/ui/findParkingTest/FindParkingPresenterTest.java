package com.example.parking.ui.findParkingTest;

import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.memorydao.ParkingSpaceDAOMemory;
import com.example.parking.memorydao.UserDAOMemory;
import com.example.parking.ui.findParking.FindParkingPresenter;

import org.junit.Before;

public class FindParkingPresenterTest {
    private FindParkingPresenter presenter;
    //private FileSelectorViewStub stub;
    //private FileLoader loader;

    @Before
    public void setup(){
        ParkingRequest pr = new ParkingRequest();
        //stub = new FileSelectorViewStub();
        UserDAO uDAO = new UserDAOMemory();
        ParkingSpaceDAO pDAO = new ParkingSpaceDAOMemory();
        //presenter = new FindParkingPresenter();
    }
}
