package com.example.library.domain;
import com.example.library.util.Pin;

import java.util.Date;


public class ParkingRequest{
    private Date date;
    private Pin pin;
    private Address address;
    private User parkedUser;
    private User requestingUser;

    public ParkingRequest(Date date, Pin pin, Address address, User parkedUser, User requestingUser) {
        this.date = date;
        this.pin = pin;
        this.address = address;
        this.parkedUser = parkedUser;
        this.requestingUser = requestingUser;
    }



    public ParkingRequest() {
        this.date = new Date();
        this.pin = new Pin();
        this.address = new Address();
        this.parkedUser = new User();
        this.requestingUser = new User();
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

    public Address getZipCode() {
        return address;
    }

    public void setZipCode(Address address) {
        this.address = address;
    }
}
