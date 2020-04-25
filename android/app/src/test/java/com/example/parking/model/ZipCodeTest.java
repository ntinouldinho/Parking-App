package com.example.parking.model;

import com.example.parking.util.ZipCode;

import org.junit.Assert;
import org.junit.Test;

public class ZipCodeTest {
    @Test
    public void setCorrectZipTest() {
        ZipCode zc = new ZipCode();
        zc.setZip(15122);
        Assert.assertEquals(15122,zc.getZip());
    }

    @Test
    public void setIncorrectZipTest() {
        ZipCode zc = new ZipCode();
        zc.setZip(1512);
        Assert.assertEquals(0,zc.getZip());
    }
}
