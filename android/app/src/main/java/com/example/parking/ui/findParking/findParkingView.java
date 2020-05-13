package com.example.parking.ui.findParking;

import android.widget.Button;

import com.example.parking.domain.Address;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.User;
import com.example.parking.util.Credits;
import com.example.parking.util.TimeRange;

import java.util.ArrayList;
import java.util.Date;

public interface findParkingView {
    String getZip();
    void makeToast(String m);
    ArrayList<Button> showParkingSpace(ArrayList<ParkingSpace> DaoParkingSpace);
    void setParkingOnClickListener(ArrayList<Button> myButtons,ArrayList <ParkingSpace> parkspa);
    String getUserName();

}
