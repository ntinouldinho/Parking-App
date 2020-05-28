package com.example.parking.ui.FindParkingTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.example.parking.domain.*;
import com.example.parking.dao.*;
import com.example.parking.memorydao.ParkingSpaceDAOMemory;
import com.example.parking.memorydao.UserDAOMemory;
import com.example.parking.ui.FindParking.FindParkingPresenter;

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
