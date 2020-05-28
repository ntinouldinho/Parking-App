package com.example.parking.ui.FindParking;

import android.widget.Button;

import com.example.parking.domain.Address;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.User;
import com.example.parking.util.Credits;
import com.example.parking.util.TimeRange;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public interface FindParkingView {
    String getZip();
    void makeToast(String m);
    void setErrorToZip(String error);
    void showParkingSpace(ArrayList<ParkingSpace> DaoParkingSpace);
    void setParkingOnClickListener(Button b,ParkingSpace parkspa);
    String getUserName();
    LocalDateTime getExpectedArrivalDateTime();

}
