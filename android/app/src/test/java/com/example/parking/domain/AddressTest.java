package com.example.parking.domain;

import com.example.parking.util.ZipCode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    private Address address;
    private String street;
    private String number;
    private ZipCode zipCode;
    @Before
    public void setup(){
        zipCode = new ZipCode();
        zipCode.setZip(18530);
        street="Vasilisis Sofias";
        number = "53";
        address = new Address();
        address.setStreet(street);
        address.setStreetNumber(number);
        address.setZipCode(zipCode);

    }
    @Test
    public void getStreetTest(){
        Assert.assertEquals(street,address.getStreet());
    }

    @Test
    public void getStreetNumberTest(){
        Assert.assertEquals(number,address.getStreetNumber());
    }

    @Test
    public void getZipCodeTest(){
        Assert.assertEquals(zipCode,address.getZipCode());
    }

}