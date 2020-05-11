package com.example.parking.ui.viewVehicles;

import android.os.Bundle;
import android.widget.Button;

import com.example.parking.domain.Vehicle;

import java.util.ArrayList;

public interface ViewVehiclesView {
    void onCreate(Bundle savedInstanceState);
    String getUserName();
    ArrayList<Button> showVehicles(ArrayList<Vehicle> vehicles);
    void setSongOnClickListener(ArrayList<Button> buttons,ArrayList<Vehicle> vehicles);
    void viewOneVehicle(Vehicle vehicle);
}
