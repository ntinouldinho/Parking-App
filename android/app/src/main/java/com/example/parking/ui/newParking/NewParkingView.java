package com.example.parking.ui.newParking;

import com.example.parking.util.TimeRange;

import java.util.ArrayList;

public interface NewParkingView {
    String getStreet();
    String getStreetNumber();
    String getZipCode();
    String getPlate();
    String getCredits();
    String getUsername();
    TimeRange getTimeRange();
    void setSpinner(ArrayList<String> plates);
    void successfullyFinishActivity();

    void makeToast(String m);

}
