package com.example.parking.util;

import com.example.parking.util.ZipCode;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ZipCodeTest {
    ZipCode zipCode;
    @Before
    public void setup(){
        zipCode = new ZipCode();
    }
    @Test
    public void setCorrectZipTest() {
        zipCode.setZip(15122);
        assertEquals(15122,zipCode.getZip());
    }

    @Test
    public void setIncorrectZipTest() {
        zipCode.setZip(1512);
        assertEquals(0,zipCode.getZip());
    }
}
