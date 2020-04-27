package com.example.parking.domain;

import com.example.parking.util.Colour;
import com.example.parking.util.Credits;
import com.example.parking.util.Pin;
import com.example.parking.util.TimeRange;
import com.example.parking.util.ZipCode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.*;

public class ParkingRequestTest {
    private ParkingRequest parkingRequest;
    private TimeRange date;
    private Pin pin;
    private User userParked;
    private User userSearching;
    Vehicle vehicle;
    Address addressParked;
    Address addressSearching;
    ZipCode zipCode;
    Credits credits;
    private ParkingSpace parkingSpace;
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<ParkingSpace> parkingList = new ArrayList<ParkingSpace>();

    @Before
    public void setup(){
        date = new TimeRange(0);
        pin = new Pin(5000);
        zipCode = new ZipCode(18560);
        credits = new Credits(10);

        vehicle = new Vehicle(Colour.Green,463,"Medium SUV Car", "APK1551","2004 Aztek","Pontiac" );

        addressParked = new Address("vasilisis","53",zipCode);
        addressSearching = new Address("zanni","40",zipCode);

        userParked = new User("kostas","kon","6950505050","email","ntinouldinho","test",addressParked,new ArrayList<Rating>(),new ArrayList<Vehicle>());
        userParked.addVehicle(vehicle);

        userSearching = new User("konnos","kon","6940404040","email","konnnos","test",addressSearching,new ArrayList<Rating>(),new ArrayList<Vehicle>());


        users.add(userParked);
        users.add(userSearching);

        parkingSpace = new ParkingSpace(addressParked,false,credits,new TimeRange(30),new Date(),userParked,"APK1551");
        parkingList.add(parkingSpace);
        parkingRequest = new ParkingRequest(date,pin,userSearching,parkingSpace);

    }

    @Test
    public void EmptyConTest() {
        ParkingRequest ok = new ParkingRequest();
    }

    @Test
    public void setTimeOfExchangeTest() {
        TimeRange d1 = new TimeRange(30);
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
    public void findOneParking() {
        users.add(new User("konnos","kon","6940404040","email","test1","test",addressSearching,new ArrayList<Rating>(),new ArrayList<Vehicle>()));

        ParkingSpace testParking1 = new ParkingSpace(new Address("agias","53",new ZipCode(18530)),false,credits,new TimeRange(30),new Date(),userParked,"APK1000");
        parkingList.add(testParking1);

        assertEquals(1,(parkingRequest.findParking(parkingList,new Address("agias","53",new ZipCode(18500)),0)).size());
    }
    @Test
    public void findMultipleParking() {
        users.add(new User("konnos","kon","6940404040","email","test1","test",addressSearching,new ArrayList<Rating>(),new ArrayList<Vehicle>()));

        ParkingSpace testParking1 = new ParkingSpace(new Address("agias","53",new ZipCode(18530)),false,credits,new TimeRange(30),new Date(),userParked,"APK1000");
        parkingList.add(testParking1);
        ParkingSpace testParking2 = new ParkingSpace(new Address("agias","53",new ZipCode(18510)),false,credits,new TimeRange(30),new Date(),userParked,"APL1000");
        parkingList.add(testParking2);

         assertEquals(2,(parkingRequest.findParking(parkingList,new Address("agias","53",new ZipCode(18500)),0)).size());
    }
    @Test
    public void findNoParking() {
        users.add(new User("konnos","kon","6940404040","email","test1","test",addressSearching,new ArrayList<Rating>(),new ArrayList<Vehicle>()));

        ParkingSpace testParking1 = new ParkingSpace(new Address("agias","53",new ZipCode(18530)),false,credits,new TimeRange(30),new Date(),userParked,"APK1000");
        parkingList.add(testParking1);
        assertEquals(0,(parkingRequest.findParking(parkingList,new Address("agias","53",new ZipCode(10000)),0)).size());

    }
    @Test
    public void ValidateWrongUserParkingTest(){
        User wrongUser = new User("konnos","kon","6940404040","email","wrong","test",addressSearching,new ArrayList<Rating>(),new ArrayList<Vehicle>());
        parkingRequest.setRequestingUser(wrongUser);
        List<Object> result = parkingRequest.validateParking(users,parkingRequest.getPin());
        int statusCode = (int)result.get(1);
        assertEquals(1,statusCode);
    }
    @Test
    public void ValidateLateUserParkingTest(){
        LocalDateTime now= parkingRequest.getDate().getTo();
        LocalDateTime changed = now.minusMinutes(35);
        parkingRequest.getDate().setTo(changed);
        System.out.println(parkingRequest.getDate().toString());
        List<Object> result = parkingRequest.validateParking(users,parkingRequest.getPin());

        int statusCode = (int)result.get(1);
        assertEquals(2,statusCode);
    }
    @Test
    public void ValidateCorrectParkingTest(){
        List<Object> result = parkingRequest.validateParking(users,parkingRequest.getPin());
        int statusCode = (int)result.get(1);
        assertEquals(3,statusCode);
    }

    @Test
    public void ValidateWrongPinParkingTest(){
        List<Object> result = parkingRequest.validateParking(users,new Pin(1000));
        int statusCode = (int)result.get(1);
        assertEquals(4,statusCode);
    }


    @Test
    public void toStringTest() {
         String str="ParkingRequest{" +
                "date=" + date +
               ", pin=" + pin +
                ", requestingUser=" + userSearching +
               ", parkingSpace=" + parkingSpace +
                '}';
        assertEquals(str,parkingRequest.toString());
    }
}