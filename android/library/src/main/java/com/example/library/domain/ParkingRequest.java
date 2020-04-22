package com.example.library.domain;
import com.example.library.util.Pin;
import com.example.library.util.ZipCode;

import java.util.ArrayList;
import java.util.Date;


public class ParkingRequest{
    private Date date;
    private Pin pin;
    private Address address;
    private User parkedUser;
    private User requestingUser;
    private ParkingSpace parkingSpace;

    public ParkingRequest(Date date, Pin pin, Address address, User parkedUser, User requestingUser,ParkingSpace parkingSpace) {
        this.date = date;
        this.pin = pin;
        this.address = address;
        this.parkedUser = parkedUser;
        this.requestingUser = requestingUser;
        this.parkingSpace=parkingSpace;

    }



    public ParkingRequest() {
        this.date = new Date();
        this.pin = new Pin();
        this.address = new Address();
        this.parkedUser = new User();
        this.requestingUser = new User();
        this.parkingSpace = new ParkingSpace();
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getParkedUser() {
        return parkedUser;
    }

    public void setParkedUser(User parkedUser) {
        this.parkedUser = parkedUser;
    }

    public User getRequestingUser() {
        return requestingUser;
    }

    public void setRequestingUser(User requestingUser) {
        this.requestingUser = requestingUser;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public ArrayList<ParkingSpace> findParking(ArrayList<ParkingSpace> parkingSpaces, int difference){
        ArrayList<ParkingSpace> list = new ArrayList<>();
        ZipCode zip = this.address.getZipCode();
        for(ParkingSpace parking:parkingSpaces){
            ZipCode currentZip = parking.getAddress().getZipCode();
            if(Math.abs(zip.getZip()-currentZip.getZip()) <= difference )list.add(parking);
        }
        if(list.isEmpty()){ findParking(parkingSpaces,difference++);}
        return list;
    }




    @Override
    public String toString() {
        return "ParkingRequest{" +
                "date=" + date +
                ", pin=" + pin +
                ", address=" + address +
                ", parkedUser=" + parkedUser +
                ", requestingUser=" + requestingUser +
                '}';
    }

}
