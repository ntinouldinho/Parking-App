package com.example.library.dao;

import com.example.library.domain.ParkingRequest;
import com.example.library.domain.ParkingSpace;
import com.example.library.util.Pin;

import java.util.ArrayList;

public interface ParkingRequestDAO {

    /**
     * Βρίσκει parking σύμφωνα με τον Τ.Κ. Αν δεν υπάρχει κοντά ψάχνει τους κοντινούς Τ.Κ.
     * @param
     * @param difference
     * @return Ο κατάλογος των αντικειμένων
     */
    ArrayList<ParkingSpace> findParking(ArrayList<ParkingSpace> parkingSpaces, int difference);

    /**
     * Είναι υπεύθυνο για την διεκπεραίωση της διαδικασίας ανταλλαγής θέσης
     * καθώς και την μεταφορά μονάδων από τον ενδιαφερόμενο στον
     * σταθμευμένο χρήστη.
     * @param pin
     * @return Επιστρέφει true εάν η διαδικασία ανταλλαγής έχει ολοκληρωθεί με επιτυχία
     */
    boolean validateParking(Pin pin);
}
