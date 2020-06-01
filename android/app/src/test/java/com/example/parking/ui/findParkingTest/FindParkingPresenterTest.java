package com.example.parking.ui.findParkingTest;

import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.memorydao.ParkingSpaceDAOMemory;
import com.example.parking.memorydao.UserDAOMemory;
import com.example.parking.ui.findParking.FindParkingPresenter;
import com.example.parking.util.Credits;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindParkingPresenterTest {
    private FindParkingPresenter presenter;
    private FindParkingViewStub view;
    private ParkingSpaceDAO pDAO;
    private List<ParkingSpace> localParkingSpaces = new ArrayList<>();
    private ParkingSpace p1;


    @Before
    public void setup(){
        ParkingRequest pr = new ParkingRequest();
        view = new FindParkingViewStub();
        UserDAO uDAO = new UserDAOMemory();
        pDAO = new ParkingSpaceDAOMemory();

        p1 = new ParkingSpace();
        p1.setPlate("FIRST PLATE");
        p1.setPrice(new Credits(1));
        pDAO.save(p1);
        localParkingSpaces.add(p1);
        ParkingSpace p2 = new ParkingSpace();
        p2.setPlate("SECONDS PLATE");
        p2.setPrice(new Credits(2));
        pDAO.save(p2);
        localParkingSpaces.add(p2);
        presenter = new FindParkingPresenter(view, uDAO, pDAO);
    }

    /**
     * Ensures all parking spaces can be shown and exist in DAO
     */
    @Test
    public void showParkingSpace(){
        view.showParkingSpace((ArrayList<ParkingSpace>) pDAO.findAll());
        Assert.assertEquals(pDAO.findAll(), localParkingSpaces);
    }

    /**
     * Ensures that a parking space can be found from the DAO if it exists
     */
    @Test
    public void findParkingSpace(){
        ParkingSpace p = new ParkingSpace();
        p.setPlate("OOO");

        Assert.assertNull(pDAO.find(p));
        Assert.assertEquals(pDAO.find(p1), p1);
    }
}
