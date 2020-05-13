package com.example.parking.ui.findParking;

import com.example.parking.domain.Address;
import com.example.parking.domain.User;
import com.example.parking.util.Credits;
import com.example.parking.util.TimeRange;

import java.util.ArrayList;
import java.util.Date;

public interface findParkingView {
    String getZip();
    void makeToast(String m);
}
