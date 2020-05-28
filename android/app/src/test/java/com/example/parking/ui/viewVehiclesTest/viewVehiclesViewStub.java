package com.example.parking.ui.viewVehiclesTest;
import android.content.Intent;

import com.example.parking.domain.Vehicle;
import com.example.parking.ui.viewOneVehicle.viewOneVehicle;
import com.example.parking.ui.viewVehicles.ViewVehicles;
import com.example.parking.ui.viewVehicles.ViewVehiclesPresenter;
import com.example.parking.ui.viewVehicles.ViewVehiclesView;

import java.util.ArrayList;

public class viewVehiclesViewStub implements ViewVehiclesView {
    ViewVehiclesPresenter presenter;
    String username,intentUsername;

    public viewVehiclesViewStub()
    {
        username = intentUsername  = "";
    }

    public void viewOneVehicle(Vehicle vehicle){
    }

    public void showVehicles(ArrayList<Vehicle> DaoVehicles){}

    public void setPresenter(ViewVehiclesPresenter presenter) {
        this.presenter = presenter;
    }

    public String getUserName()
    {
       return username;
    }

    public void setIntentUsername(String username){
        intentUsername=username;
    }

    public String getIntentUsername (){
        return intentUsername;
    }


}
