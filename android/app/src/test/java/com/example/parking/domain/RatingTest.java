package com.example.parking.domain;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import static org.junit.Assert.*;

public class RatingTest {
    private Rating rating;
    private int ratingScore;
    private String comment;

    @Before
    public void setup(){
        rating = new Rating();
        ratingScore = 5;
        comment = "Good";
        rating.setRatingScore(ratingScore);
        rating.setComment("comment");
    }

    @Test
    public void getRatingScoreTest(){
        Assert.assertEquals(ratingScore,rating.getRatingScore());
    }

    @Test
    public void getCommentTest(){
        Assert.assertEquals(comment,rating.getComment());
    }
}