package com.example.parking.ui.notifications;

import android.widget.Button;

import com.example.parking.domain.ParkingRequest;

import java.util.ArrayList;

public interface notificationView {
    ArrayList<Button> showNotifications(ArrayList<ParkingRequest> DaoParkingSpace, String notif);
    void enterPinListener(ArrayList<Button> myButtons,ArrayList<ParkingRequest> reqs);
    String getUserName();
    ArrayList<ParkingRequest> getReqs();
    void makeToast(String s);
}
