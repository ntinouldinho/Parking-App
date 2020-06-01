package com.example.parking.ui.findParking;

import android.widget.Button;

import com.example.parking.domain.ParkingSpace;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface FindParkingView {
    /**
     * @return Ο Τ.Κ.
     */
    String getZip();
    /**
     * @return Το όνομα χρήστη
     */
    String getUserName();
    /**
     * @return Η εκτιμώμενη χρονική στιγμή που θα καταυθάσει στο στημείο ο χρήστης
     */
    LocalDateTime getExpectedArrivalDateTime();
    /**
     * Εμφανίζει όλες τις έγγυρες θέσεις parking
     * @param DaoParkingSpace Λίστα με τις έγγυρες θέσεις parking
     */
    void showParkingSpace(ArrayList<ParkingSpace> DaoParkingSpace);

    void setParkingOnClickListener(Button b,ParkingSpace parkspa);
    void makeToast(String m);
    void setErrorToZip(String error);
}
