package com.example.parking.ui.notifications;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.util.Pin;

import java.util.ArrayList;

public class NotificationsPresenter {
    NotificationsView view;
    ParkingRequestDAO dao;
    UserDAO users;
    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationsPresenter(NotificationsView view, ParkingRequestDAO dao, UserDAO users){
        this.view=view;
        this.dao=dao;
        this.users=users;
        String username = view.getUserName();
        ArrayList<ParkingRequest> all = new ArrayList<>();

        for(ParkingRequest request:(ArrayList<ParkingRequest>) dao.findAll()){
            if(request.getRequestingUser().getUsername().equals(username) || request.getParkingSpace().getParkedUser().getUsername().equals(username) ){
                all.add(request);
            }
        }
        view.showNotifications(all,username);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean validateParking(ParkingRequest request, Pin pin){
       //Log.e("requesting credits befo",String.valueOf(users.find(request.getRequestingUser().getUsername()).getCredits().getPoints()));
       // Log.e("parked credits befo",String.valueOf(users.find(request.getParkingSpace().getParkedUser().getUsername()).getCredits().getPoints()));
        int results = dao.find(request).validateParking(pin);


       if(results==1){
            dao.delete(request);
           //Log.e("requesting credits afte",String.valueOf(users.find(request.getRequestingUser().getUsername()).getCredits().getPoints()));
           //Log.e("parked credits afte",String.valueOf(users.find(request.getParkingSpace().getParkedUser().getUsername()).getCredits().getPoints()));

           view.makeToast("Transaction complete");
            return true;
       }else{
           view.makeToast("Wrong pin.");
           return false;
       }
    }

    public int approveRequest(ParkingRequest request){
        int pin=Pin.createPin();
        request.setPin(new Pin(pin));
        view.makeToast("Pin generated");
        return pin;
        //Log.e("the new pin",String.valueOf(request.getPin().getPin()));
    }

    public void denyRequest(ParkingRequest request){
        request.setDate(null);
        view.makeToast("Request denied");
    }
}
