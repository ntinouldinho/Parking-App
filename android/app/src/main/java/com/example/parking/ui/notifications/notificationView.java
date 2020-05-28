package com.example.parking.ui.notifications;

import android.widget.Button;

import com.example.parking.domain.ParkingRequest;

import java.util.ArrayList;

public interface notificationView {
    String getUserName();

    /**
     * Εμφανίζει τα δυναμικά παραγώμενα κουμπιά.
     * @param DaoParkingSpace Τα εκκρεμή parking request
     * @param DaoParkingSpace Το περιεχόμενο που θα εμφανιστεί
     */
    void showNotifications(ArrayList<ParkingRequest> DaoParkingSpace, String notif);


    /**
     * Εμφανίζει ένα Toast.
     * @param s Το περιεχόμενο που θα εμφανιστεί
     */
    void makeToast(String s);
}
