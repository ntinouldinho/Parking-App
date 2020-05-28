package com.example.parking.ui.ViewVehiclesTest;
import android.content.Intent;

import com.example.parking.domain.Vehicle;
import com.example.parking.ui.ViewOneVehicle.ViewOneVehicle;
import com.example.parking.ui.ViewVehicles.*;

import java.util.ArrayList;

public class ViewVehiclesViewStub implements ViewVehiclesView {
    ViewVehiclesPresenter presenter;
    String username,intentUsername;

    public ViewVehiclesViewStub()
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
