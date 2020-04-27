package com.example.parking.util;

import com.example.parking.util.Pin;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PinTest {
    Pin pin;
    @Before
    public void setup(){
        pin = new Pin();
        pin.setPin(1234);
    }
    @Test
    public void setCorrectPinTest() {
        assertEquals(1234,pin.getPin());
    }

    @Test
    public void setIncorrectPinTest() {
        pin.setPin(12345);
        assertEquals(1234,pin.getPin());
    }

}
