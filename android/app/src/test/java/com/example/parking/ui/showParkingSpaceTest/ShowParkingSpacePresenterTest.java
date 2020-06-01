package com.example.parking.ui.showParkingSpaceTest;

import com.example.parking.dao.RatingDAO;
import com.example.parking.domain.Rating;
import com.example.parking.memorydao.RatingDAOMemory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ShowParkingSpacePresenterTest {
    private RatingDAO rDAO = new RatingDAOMemory();
    private String raterName1, raterName2;
    private Rating r1, r2;

    @Before
    public void setup(){

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
