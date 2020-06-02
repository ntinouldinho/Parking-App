package com.example.parking.ui.showParkingSpaceTest;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.dao.RatingDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.Rating;
import com.example.parking.memorydao.ParkingRequestDAOMemory;
import com.example.parking.memorydao.RatingDAOMemory;
import com.example.parking.util.Pin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ShowParkingSpacePresenterTest {
    private RatingDAO rDAO;
    private ParkingRequestDAO prDAO;
    private ParkingRequest pr;
    private String raterName1, raterName2;
    private Rating r1, r2;

    @Before
    public void setup(){
        rDAO = new RatingDAOMemory();
        prDAO = new ParkingRequestDAOMemory();

        pr = new ParkingRequest();
        pr.setPin(new Pin(1111));
        prDAO.save(pr);

        raterName1 = "rater1";
        raterName2 = "rater2";

        r1 = new Rating();
        r1.setRatingScore(4);
        r1.setRatedUsername(raterName1);
        r2 = new Rating();
        r2.setRatingScore(3);
        r2.setRatedUsername(raterName2);

        rDAO.save(r1);
        rDAO.save(r2);
    }

    /**
     * Ensures that
     */
    @Test
    public void validateParkingRequestDAO(){
        ParkingRequest retrieved = prDAO.find(pr);
        Assert.assertEquals(retrieved, pr);
        Assert.assertEquals(1, prDAO.findAll().size());
    }

    /**
     * Ensures ratings for users are set and retrieved correctly
     */
    @Test
    public void findRating(){
        Assert.assertEquals(2, rDAO.findAll().size());
        Assert.assertEquals(Collections.singletonList(r1), rDAO.findAllOfUser(raterName1));
        Assert.assertEquals(Collections.singletonList(r2), rDAO.findAllOfUser(raterName2));
        Assert.assertEquals(new ArrayList<>(), rDAO.findAllOfUser("none"));
    }
}
