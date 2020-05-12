package com.example.parking.ui.newParking;

import java.util.ArrayList;

public interface NewParkingView {
    String getStreet();
    String getStreetNumber();
    String getZipCode();
    String getPlate();
    String getCredits();
    String getUsername();
    void setSpinner(ArrayList<String> plates);
    void successfullyFinishActivity(String message);

    void makeToast(String m);
}
