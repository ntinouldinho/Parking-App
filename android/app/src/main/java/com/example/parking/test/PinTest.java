package com.example.parking.test;

import com.example.parking.util.Pin;

import org.junit.Test;
import org.junit.Assert;

public class PinTest {
    @Test
    public void setCorrectPinTest() {
        Pin p1 = new Pin();
        p1.setPin(1234);
        Assert.assertEquals(1234,p1.getPin());
    }

    @Test
    public void setIncorrectPinTest() {
        Pin p1 = new Pin();
        p1.setPin(12345);
        Assert.assertEquals(0,p1.getPin());
    }

}
