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
        ArrayList<ParkingRequest> all = new ArrayList<>();




        for(ParkingRequest request:(ArrayList<ParkingRequest>) dao.findAll()){
            if(request.getRequestingUser().getUsername().equals(username) || request.getParkingSpace().getParkedUser().getUsername().equals(username) )all.add(request);
        }
        view.setParkingOnClickListener(view.showNotifications(all,username));
    }
}
