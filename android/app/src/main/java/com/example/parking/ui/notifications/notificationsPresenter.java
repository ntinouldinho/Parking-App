package com.example.parking.ui.notifications;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.User;
import com.example.parking.util.Pin;

import java.util.ArrayList;

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
            Log.e("in array",request.toString());
            if(request.getRequestingUser().getUsername().equals(username) || request.getParkingSpace().getParkedUser().getUsername().equals(username) ){
                all.add(request);
                Log.e("added",request.toString());
            }
        }
        view.showNotifications(all,username);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void validateParking(ParkingRequest request, Pin pin){
        int test= (int) dao.find(request).validateParking((ArrayList<User>) users.findAll(),pin).get(1);
        Log.e("the result", String.valueOf(test));

    }
}
