package com.example.parking.ui.ShowParkingSpace;

import android.widget.Button;

import com.example.parking.domain.ParkingSpace;

import java.util.ArrayList;

public interface ShowParkingView {
    String getRequestingUser();
    void setParkedUser(String parkedUsername);
    void setVehicle(String plate);
    void setAddress(String zip);
    String getParkedUsername();


}
