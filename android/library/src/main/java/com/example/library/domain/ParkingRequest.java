package com.example.library.domain;
import com.example.library.util.Pin;
import com.example.library.util.ZipCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


public class ParkingRequest{
    private Date date;//date einai h wra pou ypologizei o requestingUser na ftasei sto parking
    private Pin pin;
    private User requestingUser;
    private ParkingSpace parkingSpace;

    public ParkingRequest(Date date, Pin pin, User requestingUser,ParkingSpace parkingSpace) {
        this.date = date;
        this.pin = pin;
        this.requestingUser = requestingUser;
        this.parkingSpace=parkingSpace;
    }

    public ParkingRequest() {
        this.date = new Date();
        this.pin = new Pin();
        this.requestingUser = new User();
        this.parkingSpace = new ParkingSpace();
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public ArrayList<ParkingSpace> findParking(ArrayList<ParkingSpace> parkingSpaces, int difference){
        ArrayList<ParkingSpace> list = new ArrayList<>();
        ZipCode zip = this.parkingSpace.getAddress().getZipCode();
        for(ParkingSpace parking:parkingSpaces){
            ZipCode currentZip = parking.getAddress().getZipCode();
            if(Math.abs(zip.getZip()-currentZip.getZip()) <= difference )list.add(parking);
        }
        if(list.isEmpty()){ findParking(parkingSpaces,++difference);}
        return list;
    }



    /**
     * Είναι υπεύθυνο για την διεκπεραίωση της διαδικασίας ανταλλαγής θέσης
     * καθώς και την μεταφορά μονάδων από τον ενδιαφερόμενο στον
     * σταθμευμένο χρήστη.
     * @param pin
     * @return Επιστρέφει true εάν η διαδικασία ανταλλαγής έχει ολοκληρωθεί με επιτυχία
     */
    public boolean validateParking(Pin pin){
        if(pin.getPin()==getPin().getPin()){//get pin of class pin from parkingRequest pin
            getParkingSpace().makeParkingUnavailable();
            requestingUser.getCredits().removeCredits(parkingSpace.getPrice().getPoints());
            parkingSpace.getParkedUser().getCredits().addCredits(parkingSpace.getPrice().getPoints());
            //TODO thn enalaktikh roh 1b ths Επιβεβαίωση διαθεσιμότητας θέσης
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "ParkingRequest{" +
                "date=" + date +
                ", pin=" + pin +
                ", requestingUser=" + requestingUser +
                ", parkingSpace=" + parkingSpace +
                '}';
    }
}
