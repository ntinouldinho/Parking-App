package com.example.parking.util;

import com.example.parking.util.Credits;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CreditsTest {
    private Credits credits;

    @Test
    public void FullConTest() {
       Credits c = new Credits(10);
    }

    @Before
    public void setup(){
        credits = new Credits();
    }
    @Test
    public void addCreditsTest(){
        credits.addCredits(10);
        assertEquals(10,credits.getPoints());
    }

    @Test
    public void removeValidCreditsTest(){
        credits.addCredits(10);
        credits.removeCredits(5);
        assertEquals(5,credits.getPoints());
    }

    @Test
    public void removeInvalidCreditsTest(){
        credits.addCredits(10);
        credits.removeCredits(11);
        assertEquals(10,credits.getPoints());
    }
}
