package com.example.parking.ui.notificationsTest;
import android.widget.Button;

import com.example.parking.domain.ParkingRequest;
import com.example.parking.ui.notifications.notificationView;

import java.util.ArrayList;

public class notificationsViewStub implements notificationView {
    String username;
    ArrayList<ParkingRequest> toApprove = new ArrayList<>();
    ArrayList<ParkingRequest> toEnterPin = new ArrayList<>();
    public notificationsViewStub(){
        username="";
    }

    @Override
    public void showNotifications(ArrayList<ParkingRequest> DaoParkingSpace, String notif) {
        return ;
    }

    @Override
    public void enterPinListener(Button myButtons, ParkingRequest reqs) {

    }

    @Override
    public String getUserName() {
        return username;
    }

    public void setUsername(String user){
        this.username=user;
    }

    @Override
    public void makeToast(String s) {

    }
}
