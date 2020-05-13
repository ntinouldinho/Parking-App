package com.example.parking.ui.notifications;

import android.widget.Button;

import com.example.parking.domain.ParkingRequest;

import java.util.ArrayList;

public interface notificationView {
    ArrayList<Button> showNotifications(ArrayList<ParkingRequest> DaoParkingSpace, String notif);
    void setParkingOnClickListener(ArrayList<Button> myButtons);
    String getUserName();
}
