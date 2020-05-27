package com.example.parking.ui.viewVehicles;

import android.os.Bundle;
import android.widget.Button;

import com.example.parking.domain.Vehicle;

import java.util.ArrayList;

public interface ViewVehiclesView {
    String getUserName();
    void setIntentUsername(String username);
    String getIntentUsername ();


    /**
     * Εμφανίζει τα στοιχεία ενός vehicle.
     * @param vehicle Τα vehicles που επιλέχθηκε.
     */
    void viewOneVehicle(Vehicle vehicle);

    /**
     * Εμφανίζει το vehicle που θα επιλεγεί.
     * @param b Το button.
     * @param v To vehicle.
     */
    void setVehicleOnClickListener(Button b,Vehicle v);

    /**
     * Εμφανίζει τα vehicles ενος user.
     * @param DaoVehicles Τα vehicles του user.
     */
    void showVehicles(ArrayList<Vehicle> DaoVehicles);
}
