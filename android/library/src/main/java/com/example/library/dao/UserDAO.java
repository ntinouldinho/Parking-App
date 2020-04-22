package com.example.library.dao;

import com.example.library.domain.Rating;
import com.example.library.domain.User;
import com.example.library.domain.Vehicle;

import java.util.ArrayList;

public interface UserDAO {

    /**
    Προσθέτει ενα όχημα αν δεν υπάρχει ήδη στον χρήστη.
    @param vehicle το όχημα προς προσθήκη.
    */
    ArrayList<Vehicle> addVehicle(Vehicle vehicle,ArrayList<Vehicle> vehicles);

    /**Αφαιρειί ένα όχημα (μόνο αν ο χρήστης έχει 2 και πάνω.
     *
     * @param vehicle το όχημα προς αφαίρεση.
     */
    public ArrayList<Vehicle> removeVehicle (Vehicle vehicle,ArrayList<Vehicle> vehicles);

    /**
     *
     * @return τον Μ.Ο. αξιολογήσεων.
     */
    public double calculateRating(ArrayList<Rating> rating);//Υπολογίζει τον μέσο όρο αξιολογήσεων

}
