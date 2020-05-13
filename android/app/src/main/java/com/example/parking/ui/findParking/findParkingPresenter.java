package com.example.parking.ui.findParking;

import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.Address;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.User;
import com.example.parking.ui.newParking.NewParkingView;
import com.example.parking.util.ZipCode;

import java.util.ArrayList;
import java.util.List;

public class findParkingPresenter {
    findParkingView view;
    UserDAO userDAO;
    ParkingSpaceDAO parkingSpaceDAO;


    public findParkingPresenter(findParkingView view, UserDAO userDAO, ParkingSpaceDAO parkingSpaceDAO) {
        this.view = view;
        this.userDAO = userDAO;
        this.parkingSpaceDAO = parkingSpaceDAO;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<ParkingSpace> find(){

        List<ParkingSpace> park = parkingSpaceDAO.findAllAvailable();
        ParkingRequest pr = new ParkingRequest();
        ArrayList<ParkingSpace> ps = new ArrayList<ParkingSpace>(park);
        ArrayList<ParkingSpace> test = pr.findParking(ps,new Address("","",new ZipCode(Integer.valueOf(view.getZip()))),30);
        for(ParkingSpace p: test){
            view.makeToast(p.toString());
        }
        return test;

    }
}
