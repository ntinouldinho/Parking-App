package com.example.parking.domain;

import com.example.parking.util.Pin;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ParkingRequestTest {
    private ParkingRequest parkingRequest;
    private Date date;
    private Pin pin;
    private User user;
    private ParkingSpace parkingSpace;
    private List<ParkingSpace> parkingList;

    @Before
    public void setup(){
        Date date = new Date();

        //parkingSpace = new ParkingSpace(0,0);
       // parkingRequest=new ParkingRequest();
    }
    @Test
    public void test(){

    }
}