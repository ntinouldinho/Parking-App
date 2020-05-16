package com.example.parking.ui.findParkingTest;
import android.widget.Button;
import android.widget.EditText;

import com.example.parking.domain.ParkingSpace;
import com.example.parking.ui.findParking.findParkingPresenter;
import  com.example.parking.ui.findParking.findParkingView;
import com.example.parking.ui.helper.DurationSpecifier;
import com.example.parking.util.TimeRange;

import java.util.ArrayList;

public class findParkingViewStub implements findParkingView {

    ArrayList<ParkingSpace> spaces = new ArrayList<>();
    findParkingPresenter presenter;
    String zipcode;
    EditText ZipCodeEditText;
    ParkingSpace parking;
    DurationSpecifier durationSpecifier;

    @Override
    public String getZip() {
        return zipcode;
    }

    @Override
    public void makeToast(String m) {

    }

    @Override
    public ArrayList<Button> showParkingSpace(ArrayList<ParkingSpace> DaoParkingSpace) {
        return null;
    }

    @Override
    public void setParkingOnClickListener(Button b, ParkingSpace parkspa) {

    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public TimeRange getTimeRange() {
        return null;
    }
}
