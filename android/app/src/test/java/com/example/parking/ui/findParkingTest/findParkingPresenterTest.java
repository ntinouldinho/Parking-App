package com.example.parking.ui.findParkingTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.example.parking.domain.*;
import com.example.parking.dao.*;
import com.example.parking.memorydao.ParkingSpaceDAOMemory;
import com.example.parking.memorydao.UserDAOMemory;
import com.example.parking.ui.findParking.findParkingPresenter;

public class findParkingPresenterTest {
    private findParkingPresenter presenter;
    //private FileSelectorViewStub stub;
    //private FileLoader loader;

    @Before
    public void setup(){
        ParkingRequest pr = new ParkingRequest();
        //stub = new FileSelectorViewStub();
        UserDAO uDAO = new UserDAOMemory();
        ParkingSpaceDAO pDAO = new ParkingSpaceDAOMemory();
        //presenter = new findParkingPresenter();
    }
}
