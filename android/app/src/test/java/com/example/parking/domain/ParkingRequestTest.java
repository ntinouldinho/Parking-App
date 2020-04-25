package com.example.parking.domain;

import com.example.parking.util.Pin;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ParkingRequestTest {
    private ParkingRequest parkingRequest;
    private Date date;
    private Pin pin;
    private User user;
    private ParkingSpace parkingSpace;

    @Before
    public void setup(){
        parkingSpace = new ParkingSpace(0,0)
        parkingRequest=new ParkingRequest()
    }
}