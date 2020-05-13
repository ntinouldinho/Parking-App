package com.example.parking.ui.showParkingSpace;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingRequestDAO;
import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.User;
import com.example.parking.util.Pin;
import com.example.parking.util.TimeRange;

import java.time.LocalDateTime;

public class ShowParkingPresenter {
    ShowParkingView view;
    UserDAO userDAO;
    ParkingSpaceDAO parkingDAO;
    ParkingRequestDAO parkingRequestDAO;

    public ShowParkingPresenter(ShowParkingView view, UserDAO userDAO, ParkingSpaceDAO parkingDAO, ParkingRequestDAO parkingRequestDAO) {
        this.view = view;
        this.userDAO = userDAO;
        this.parkingDAO = parkingDAO;
        this.parkingRequestDAO = parkingRequestDAO;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    void add(ParkingSpace parkingSpace){

        parkingRequestDAO.save(new ParkingRequest(new TimeRange(LocalDateTime.now(),30),new Pin(), userDAO.find(view.getRequestingUser()),parkingSpace));
    }

}
