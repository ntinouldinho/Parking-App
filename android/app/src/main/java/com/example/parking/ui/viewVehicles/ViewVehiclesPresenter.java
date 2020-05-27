package com.example.parking.ui.viewVehicles;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;
import com.example.parking.ui.viewOneVehicle.viewOneVehicle;
import com.example.parking.ui.viewVehicles.*;

import java.util.ArrayList;

public class ViewVehiclesPresenter {
    private ViewVehiclesView view;
    private ArrayList<Vehicle> vehicles;
    private User user;
    private UserDAO dao;


    /**
     * Αρχικοποεί τον Presenter.
     * @param view Ένα instance του view
     * @param dao Ένα instance του user
     */
    ViewVehiclesPresenter(ViewVehiclesView view,UserDAO dao){
        this.view=view;
        this.user = dao.find(view.getUserName());
        showVehicles();
    }

    /**
     * Εμφανίζει τα vehicles ενος user.
     */
    void showVehicles(){
        view.showVehicles(user.getVehicles());
    }

    /**
     * Εμφανίζει τα στοιχεία ενός vehicle.
     * @param vehicle Τα vehicles που επιλέχθηκε.
     */
    void viewOneVehicle(Vehicle vehicle){
        Log.e("vehicle",vehicle.toString());
        view.viewOneVehicle(vehicle);
    }



}
