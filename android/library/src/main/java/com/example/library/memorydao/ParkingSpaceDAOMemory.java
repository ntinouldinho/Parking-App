package com.example.library.memorydao;

import com.example.library.dao.ParkingRequestDAO;
import com.example.library.dao.ParkingSpaceDAO;

import java.util.Date;

public class ParkingSpaceDAOMemory implements ParkingSpaceDAO {

    /**
     * Αλλάζει την κατάσταση της θέσης πάρκινγκ
     * σε μη διαθέσιμη καθώς
     * μπορεί να έχει ολοκληρωθεί μία ανταλλαγή
     * ή να μην θέλει ο σταθμευμένος χρήστης να
     * την έχει ανοιχτή προς ανταλλαγή
     */

    public void makeParkingUnavailable(){
        availability=false;
        setTimeOfExchange(new Date(System.currentTimeMillis()));
    }


    /**
     * Αλλάζει την κατάσταση της θέσης πάρκινγκ
     * σε διαθέσιμη καθώς μπορεί να υπήρξε ένα
     * πρόβλημα στην ανταλλαγή και να θέλει ο
     * σταθμευμένος χρήστης να θέλει ακόμα να
     * δώσει τη θέση του.
     */

    public void makeParkingAvailable(){
        availability=true;
        setTimeOfExchange(new Date());
    }
}
