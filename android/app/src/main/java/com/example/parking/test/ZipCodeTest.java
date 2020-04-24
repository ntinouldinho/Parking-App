package com.example.parking.test;
import com.example.parking.util.ZipCode;

import org.junit.Test;
import org.junit.Assert;

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
