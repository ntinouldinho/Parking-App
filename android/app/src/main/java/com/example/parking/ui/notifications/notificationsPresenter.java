package com.example.parking.ui.notifications;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.User;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.util.Pin;

import java.util.ArrayList;
import java.util.List;

public class notificationsPresenter {
    notificationView view;
    ParkingRequestDAO dao;
    UserDAO users;
    @RequiresApi(api = Build.VERSION_CODES.O)
    notificationsPresenter(notificationView view, ParkingRequestDAO dao, UserDAO users){
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
    boolean validateParking(ParkingRequest request, Pin pin){
//        Log.e("requesting before",String.valueOf(users.find(request.getRequestingUser().getUsername()).getCredits().getPoints())+request.getRequestingUser().getUsername());
//        Log.e("parked before",String.valueOf(users.find(request.getParkingSpace().getParkedUser().getUsername()).getCredits().getPoints())+request.getParkingSpace().getParkedUser().getUsername());

        User requesting = users.find(request.getRequestingUser().getUsername());
        User parked = users.find(view.getUserName());
        int results = dao.find(request).validateParking(parked,requesting,pin);


       if(results==1){
            dao.delete(request);
            view.makeToast("Transaction complete");
            return true;
       }else{
           view.makeToast("Wrong pin.");
           return false;
       }
//        Log.e("requesting before",String.valueOf(users.find(request.getRequestingUser().getUsername()).getCredits().getPoints())+request.getRequestingUser().getUsername());
//        Log.e("parked before",String.valueOf(users.find(request.getParkingSpace().getParkedUser().getUsername()).getCredits().getPoints())+request.getParkingSpace().getParkedUser().getUsername());
//        Log.e("the parking",request.toString());
    }
}
