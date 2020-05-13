package com.example.parking.ui.notifications;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.domain.ParkingRequest;

import java.util.ArrayList;

public class notificationsPresenter {
    notificationView view;
    ParkingRequestDAO dao;

    @RequiresApi(api = Build.VERSION_CODES.O)
    notificationsPresenter(notificationView view, ParkingRequestDAO dao){
        this.view=view;
        this.dao=dao;
        String username = view.getUserName();
        ArrayList<ParkingRequest> waitingForApproval = new ArrayList<>();
        ArrayList<ParkingRequest> waitingForArrival = new ArrayList<>();
        ArrayList<ParkingRequest> hasToGo = new ArrayList<>();
        for(ParkingRequest request:(ArrayList<ParkingRequest>) dao.findAll()){
            if(request.getRequestingUser().getUsername().equals(username) && request.getPin()==null) waitingForApproval.add(request);
            if(request.getRequestingUser().getUsername().equals(username) && request.getPin()!=null) hasToGo.add(request);
            if(request.getParkingSpace().getParkedUser().getUsername().equals(username)) waitingForArrival.add(request);
        }
        view.setParkingOnClickListener(view.showNotifications(waitingForApproval,"waitingForApproval"));
        view.setParkingOnClickListener(view.showNotifications(waitingForArrival,"waitingForArrival"));
        view.setParkingOnClickListener(view.showNotifications(hasToGo,"hasToGo"));
    }
}
