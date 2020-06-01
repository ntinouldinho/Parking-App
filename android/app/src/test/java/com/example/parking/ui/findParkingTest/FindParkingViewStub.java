package com.example.parking.ui.findParkingTest;
import android.widget.Button;
import android.widget.EditText;

import com.example.parking.domain.ParkingSpace;
import com.example.parking.ui.findParking.FindParkingPresenter;
import com.example.parking.ui.findParking.FindParkingView;
import com.example.parking.ui.helper.DurationSpecifier;
import com.example.parking.util.TimeRange;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FindParkingViewStub implements FindParkingView
{
    ArrayList<ParkingSpace> spaces = new ArrayList<>();
    FindParkingPresenter presenter;
    String zipcode,toast;
    EditText ZipCodeEditText;
    ParkingSpace parking;
    DurationSpecifier durationSpecifier;

    public FindParkingViewStub()
    {
        zipcode = "";
    }

    @Override
    public String getZip() {
        return zipcode;
    }

    @Override
    public void makeToast(String m) {
        toast = m;
    }

    public String getToast()
    {
        return toast;
    }

    @Override
    public void setErrorToZip(String error) {

    }

    @Override
    public void showParkingSpace(ArrayList<ParkingSpace> DaoParkingSpace) {
        for (ParkingSpace p : DaoParkingSpace){
            System.out.println(p);
        }
    }

    @Override
    public void setParkingOnClickListener(Button b, ParkingSpace parkspa) {

    }

    @Override
    public String getUserName() {
        return "test name";
    }

    @Override
    public LocalDateTime getExpectedArrivalDateTime()
    {
        return LocalDateTime.now().plusMinutes(30);
    }

    public TimeRange getTimeRange() {
        return new TimeRange(30);
    }
}
