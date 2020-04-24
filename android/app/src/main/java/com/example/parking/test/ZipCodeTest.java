package com.example.parking.test;
import com.example.parking.util.ZipCode;

import org.junit.Test;
import org.testng.Assert;
import org.testng.junit.*;

public class ZipCodeTest {
    @Test
    public void setZipTest() {
        ZipCode zc = new ZipCode();
        Assert.assertEquals(true,zc.setZip(15125));
        Assert.assertEquals(false,zc.setZip(1512));
    }
}
