package com.example.parking.test;

import com.example.parking.util.Credits;

import org.junit.Test;
import org.testng.Assert;

public class CreditsTest {
    @Test
    public void addCreditsTest(){
        Credits c = new Credits();
        c.addCredits(10);
        Assert.assertEquals(10,c.getPoints());
    }

    public void removeCreditsTest(){

    }
}
