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

    @Test
<<<<<<< HEAD
    public void removeValidCreditsTest(){
        Credits c = new Credits();
        c.addCredits(10);
        c.removeCredits(5);
        Assert.assertEquals(5,c.getPoints());
    }
=======
    public void removeCreditsTest(){
>>>>>>> 6c445e1007a105bf6c6199b614c04e82db0d5a67

    @Test
    public void removeInvalidCreditsTest(){
        Credits c = new Credits();
        c.addCredits(10);
        c.removeCredits(11);;
        Assert.assertEquals(10,c.getPoints());
    }
}
