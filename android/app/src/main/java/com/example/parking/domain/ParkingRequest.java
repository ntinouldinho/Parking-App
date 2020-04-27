package com.example.parking.domain;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.parking.util.Pin;
import com.example.parking.util.TimeRange;
import com.example.parking.util.ZipCode;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


public class ParkingRequest{
    private TimeRange date;//date einai h wra pou ypologizei o requestingUser na ftasei sto parking
    private Pin pin;
    private User requestingUser;
    private ParkingSpace parkingSpace;

    public ParkingRequest(TimeRange date, Pin pin, User requestingUser,ParkingSpace parkingSpace) {
        this.date = date;
        this.pin = pin;
        this.requestingUser = requestingUser;
        this.parkingSpace=parkingSpace;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ParkingRequest() {
        this.date = new TimeRange(0);
        this.pin = new Pin();
        this.requestingUser = new User();
        this.parkingSpace = new ParkingSpace();
    }


    public TimeRange getDate() {
        return date;
    }

    public void setDate(TimeRange date) {
        this.date = date;
    }

    public Pin getPin() {
        return pin;
    }

    public void setPin(Pin pin) {
        this.pin = pin;
    }

    public User getRequestingUser() {
        return requestingUser;
    }

    public void setRequestingUser(User requestingUser) {
        this.requestingUser = requestingUser;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    /**
     * Βρίσκει parking σύμφωνα με τον Τ.Κ. Αν δεν υπάρχει κοντά ψάχνει τους κοντινούς Τ.Κ.
     * @param parkingSpaces Λίστα με ολα τα διαθέσιμα {@code ParkingSpace} αντικείμενα
     * @param difference Μέγιστη "απόσταση" για ψάξιμο, αναπαραστόμενη ως διαφορά των Zip Codes
     * @return Ο κατάλογος των αντικειμένων
     */

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<ParkingSpace> findParking(ArrayList<ParkingSpace> parkingSpaces, Address address,int difference){
        ArrayList<ParkingSpace> list = new ArrayList<>();
        ZipCode zip = address.getZipCode();
        for(ParkingSpace parking:parkingSpaces){
            ZipCode currentZip = parking.getAddress().getZipCode();
            if(Math.abs(zip.getZip()-currentZip.getZip()) <= difference )list.add(parking);
        }
        if(list.isEmpty()){ findParking(parkingSpaces,address,++difference);}
        return list;
    }



    /**
     * Είναι υπεύθυνο για την διεκπεραίωση της διαδικασίας ανταλλαγής θέσης
     * καθώς και την μεταφορά μονάδων από τον ενδιαφερόμενο στον
     * σταθμευμένο χρήστη.
     * @param pin
     * @return Επιστρέφει true εάν η διαδικασία ανταλλαγής έχει ολοκληρωθεί με επιτυχία
     */

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean validateParking(ArrayList<User> users,Pin pin){
        TimeRange currentTime = new TimeRange(0);
        currentTime.setFrom(date.getFrom());
        long minutesDif = currentTime.getDifference();
        int mod = (int)minutesDif%3;
        int penalty = mod*1;
        if(minutesDif>=30)penalty+=2;
        if(pin.getPin()==getPin().getPin()){//get pin of class pin from parkingRequest pin
            getParkingSpace().makeParkingUnavailable();
            for(User user: users){
                if(user.getUsername().equals(getRequestingUser().getUsername())) {
                    user.getCredits().removeCredits(getParkingSpace().getPrice().getPoints());
                    user.setPenalty(penalty);
                }
                if(user.getUsername().equals(getParkingSpace().getParkedUser().getUsername())){
                    user.getCredits().addCredits(getParkingSpace().getPrice().getPoints());
                }
            }
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        Locale locale = new Locale("gr", "GR");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String dateS = dateFormat.format(date);
        return "ParkingRequest{" +
                "date=" + dateS +
                ", pin=" + pin +
                ", requestingUser=" + requestingUser +
                ", parkingSpace=" + parkingSpace +
                '}';
    }
}
