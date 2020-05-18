package com.example.parking.ui.viewVehicles;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;
import com.example.parking.ui.viewOneVehicle.viewOneVehicle;

import java.util.ArrayList;

public class ViewVehiclesPresenter {
    private ViewVehiclesView view;
    private ArrayList<Vehicle> vehicles;
    private User user;
    private UserDAO dao;

    ViewVehiclesPresenter(ViewVehiclesView view,UserDAO dao){
        this.view=view;
        this.user = dao.find(view.getIntentUsername());
        this.vehicles = user.getVehicles();
        showVehicles();
    }

    void showVehicles(){
        //ArrayList<Button> buttons = view.showVehicles();
        //view.setSongOnClickListener(buttons,vehicles);
    }



}
