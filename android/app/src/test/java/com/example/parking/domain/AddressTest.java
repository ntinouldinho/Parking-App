package com.example.parking.domain;

import com.example.parking.util.ZipCode;

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
        address = new Address(street,number,zipCode);
    }

}