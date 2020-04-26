package com.example.parking.domain;

import com.example.parking.util.Colour;
import com.example.parking.util.Credits;
import com.example.parking.util.Pin;
import com.example.parking.util.TimeRange;
import com.example.parking.util.ZipCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
    private List<ParkingSpace> parkingList = new ArrayList<ParkingSpace>();

    @Before
    public void setup(){
        date = new Date();
        pin = new Pin(5000);
        zipCode = new ZipCode(18560);
        credits = new Credits(10);
        vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );

        addressParked = new Address("vasilisis","53",zipCode);
        addressSearching = new Address("zanni","40",zipCode);

        userParked = new User("kostas","kon","6950505050","email","ntinouldinho","test",addressParked,new ArrayList<Rating>(),new ArrayList<Vehicle>());
        userParked.addVehicle(vehicle);

        userSearching = new User("konnos","kon","6940404040","email","konnnos","test",addressSearching,new ArrayList<Rating>(),new ArrayList<Vehicle>());

        parkingSpace = new ParkingSpace(addressParked,false,credits,new TimeRange(30),new Date(),userParked,"APK1551");
        parkingList.add(parkingSpace);
        parkingRequest = new ParkingRequest(new Date(),pin,userSearching,parkingSpace);

    }

    @Test
    public void setTimeOfExchangeTest() {
        Date d1 = new Date(2019, 12, 13);
        parkingRequest.setDate(d1);
        assertEquals(d1,parkingRequest.getDate());
    }
    @Test
    public void getPin() {
        assertEquals(pin,parkingRequest.getPin());
    }

    @Test
    public void setPin() {
        Pin p1 = new Pin(1000);
        parkingRequest.setPin(p1);
        assertEquals(p1,parkingRequest.getPin());
    }

    @Test
    public void getRequestingUser() {
        assertEquals(userSearching,parkingRequest.getRequestingUser());
    }

    @Test
    public void setRequestingUser() {
        User user = new User("kostas","kon","6950505050","email","ntinouldinho","test",addressParked,new ArrayList<Rating>(),new ArrayList<Vehicle>());
        parkingRequest.setRequestingUser(user);
        assertEquals(user,parkingRequest.getRequestingUser());
    }

    @Test
    public void getParkingSpace() {
        assertEquals(parkingSpace,parkingRequest.getParkingSpace());
    }

    @Test
    public void setParkingSpace() {
        ParkingSpace parkingSpaceTest = new ParkingSpace(addressParked,false,credits,new TimeRange(30),new Date(),userParked,"APK1001");
        parkingRequest.setParkingSpace(parkingSpaceTest);
        assertEquals(parkingSpaceTest,parkingRequest.getParkingSpace());
    }

    @Test
    public void findParking() {
    }

    @Test
    public void validateParking() {
    }

//    @Test
//    public void testToString() {
//        Locale locale = new Locale("gr", "GR");
//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
//        String dateS = dateFormat.format(date);
//        String test= "ParkingRequest{" +
//                "date=" + dateS +
//                ", pin=" + pin +
//                ", requestingUser=" + userSearching +
//                ", parkingSpace=" + parkingSpace +
//                '}';
//        assertEquals(test,parkingRequest.toString());
//    }
}