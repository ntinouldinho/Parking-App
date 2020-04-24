package com.example.parking.test;

import com.example.parking.util.Pin;

import org.junit.Test;
import org.testng.Assert;
import org.testng.junit.*;

public class PinTest {
    @Test
    public void setPinTest() {
        Pin p1 = new Pin();
        Assert.assertEquals(true,p1.setPin(1234));
        Assert.assertEquals(false,p1.setPin(12345));
    }
}
