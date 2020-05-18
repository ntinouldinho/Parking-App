package com.example.parking.ui.notifications;

import android.widget.Button;

import com.example.parking.domain.ParkingRequest;

import java.util.ArrayList;

public interface notificationView {
    void showNotifications(ArrayList<ParkingRequest> DaoParkingSpace, String notif);
    void enterPinListener(Button myButtons,ParkingRequest reqs);
    String getUserName();
    void makeToast(String s);
}
