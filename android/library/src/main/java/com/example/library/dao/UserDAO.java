package com.example.library.dao;

import com.example.library.domain.User;
import com.example.library.domain.Vehicle;

public interface UserDAO {

    /**
    Προσθέτει ενα όχημα αν δεν υπάρχει ήδη στον χρήστη.
    @param vehicle το όχημα προς προσθήκη.
    */
    void addVehicle(Vehicle vehicle);

    /**Αφαιρειί ένα όχημα (μόνο αν ο χρήστης έχει 2 και πάνω.
     *
     * @param vehicle
     */
    void removeVehicle(Vehicle vehicle);

    /**Υπολογίζει τον μέσο όρο αξιολογήσεων
     *
     * @return τον Μ.Ο. αξιολογήσεων.
     */

    double calculateRating();

}
