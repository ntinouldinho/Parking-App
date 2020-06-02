package com.example.parking.ui.newParkingTest;

import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.memorydao.ParkingSpaceDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NewParkingPresenterTest {
    ParkingSpace p1;
    ParkingSpaceDAO pDAO;

    @Before
    public void setup(){
        p1 = new ParkingSpace();
        p1.setPlate("IXX-454");
        pDAO = new ParkingSpaceDAOMemory();
        pDAO.save(p1);
    }

    /**
     * Επαληθεύει πως η αποθήκευση, η ανάκτηση και η διαγραφή των θέσεων απο το DAO γίνεται σωστά
     */
    @Test
    public void validateParkingSpaceIsSaved()
    {
        ParkingSpace retrieved = pDAO.find(p1);
        Assert.assertEquals(retrieved, p1);
        Assert.assertEquals(1, pDAO.findAll().size());

        pDAO.delete(p1);
        Assert.assertEquals(0, pDAO.findAll().size());
    }
}
