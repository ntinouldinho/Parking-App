package com.example.parking.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatingTest {
    private Rating rating;
    @Before
    public void setup(){
        rating = new Rating();
        rating.setRatingScore(5);
        rating.setComment("Good");
    }
}