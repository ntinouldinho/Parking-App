package com.example.parking.domain;

import com.example.parking.util.Colour;
import com.example.parking.util.Credits;
import com.example.parking.util.Pin;
import com.example.parking.util.TimeRange;
import com.example.parking.util.ZipCode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ParkingRequestTest {
    private ParkingRequest parkingRequest;
    private Date date;
    private Pin pin;
    private User userParked;
    private User userSearching;
    Vehicle vehicle;
    Address addressParked;
    Address addressSearching;
    ZipCode zipCode;
    Credits credits;
    private ParkingSpace parkingSpace;
    private List<ParkingSpace> parkingList;

    @Before
    public void setup(){
        Date date = new Date();
        pin = new Pin(5000);
        zipCode = new ZipCode(18560);
        credits = new Credits(10);
        vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );

        addressParked = new Address("vasilisis","53",zipCode);
        addressSearching = new Address("zanni","40",zipCode);
        userParked = new User("kostas","kon","6950505050","email","ntinouldinho","test",addressParked,new ArrayList<Rating>(),new ArrayList<Vehicle>());
        userSearching = new User("konnos","kon","6940404040","email","konnnos","test",addressSearching,new ArrayList<Rating>(),new ArrayList<Vehicle>());
        parkingSpace = new ParkingSpace(addressParked,false,credits,new TimeRange(30),new Date(),userParked);
        parkingList.add(parkingSpace);
        parkingRequest = new ParkingRequest(new Date(),pin,userSearching,parkingSpace);
        //parkingSpace = new ParkingSpace(0,0);
       // parkingRequest=new ParkingRequest();
    }
    @Test
    public void test(){

    }
}