package com.example.library.dao;

import com.example.library.domain.ParkingRequest;
import com.example.library.domain.ParkingSpace;
import com.example.library.util.Pin;

import java.util.ArrayList;

public interface ParkingRequestDAO {
    public ArrayList<ParkingSpace> findParking(ArrayList<ParkingSpace> parkingSpaces, int difference);//Βρίσκει parking σύμφωνα με τον Τ.Κ. Αν δεν υπάρχει κοντά ψάχνει τους κοντινούς Τ.Κ.
    public boolean validateParking(Pin pin);
}
