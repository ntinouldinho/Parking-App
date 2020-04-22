package com.example.library.dao;

import com.example.library.domain.User;
import com.example.library.domain.Vehicle;

public interface UserDAO {
    public void addVehicle(Vehicle vehicle);//Προσθέτει ενα όχημα αν δεν υπάρχει ήδη στον χρήστη.

    public void removeVehicle(Vehicle vehicle);//Αφαιρειί ένα όχημα (μόνο αν ο χρήστης έχει 2 και πάνω.

    public double calculateRating();//Υπολογίζει τον μέσο όρο αξιολογήσεων

}
