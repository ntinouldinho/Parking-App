package com.example.parking.ui.FindParking;

import android.os.Build;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.Address;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.User;
import com.example.parking.ui.NewParking.NewParkingView;
import com.example.parking.util.TimeRange;
import com.example.parking.util.ZipCode;

import java.util.ArrayList;
import java.util.List;

public class FindParkingPresenter {
    FindParkingView view;
    UserDAO userDAO;
    ParkingSpaceDAO parkingSpaceDAO;


    public FindParkingPresenter(FindParkingView view, UserDAO userDAO, ParkingSpaceDAO parkingSpaceDAO) {
        this.view = view;
        this.userDAO = userDAO;
        this.parkingSpaceDAO = parkingSpaceDAO;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void find(){
       if(validateZip()) {
           ArrayList<ParkingSpace> results = new ParkingRequest().FindParking((ArrayList<ParkingSpace>) parkingSpaceDAO.findAllAvailable(), new Address("", "", new ZipCode(Integer.valueOf(view.getZip()))), 30, view.getExpectedArrivalDateTime());
           view.showParkingSpace(results);
       }
    }

    public boolean validateZip(){
        String zip = view.getZip();
        if(zip.isEmpty()){
            view.setErrorToZip("ZipCode cannot be empty");
            return false;
        }else if(zip.length()!=5){
            view.setErrorToZip("ZipCode must be 5 digits");
            return false;
        }else{
            view.setErrorToZip(null);
            return true;
        }
    }


}
