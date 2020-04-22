package com.example.library.dao;

public interface ParkingSpaceDAO {
    /**
     * Αλλάζει την κατάσταση της θέσης πάρκινγκ
     * σε μη διαθέσιμη καθώς
     * μπορεί να έχει ολοκληρωθεί μία ανταλλαγή
     * ή να μην θέλει ο σταθμευμένος χρήστης να
     * την έχει ανοιχτή προς ανταλλαγή
     */
    void makeParkingUnavailable();

    /**
     * Αλλάζει την κατάσταση της θέσης πάρκινγκ
     * σε διαθέσιμη καθώς μπορεί να υπήρξε ένα
     * πρόβλημα στην ανταλλαγή και να θέλει ο
     * σταθμευμένος χρήστης να θέλει ακόμα να
     * δώσει τη θέση του.
     */
    void makeParkingAvailable();
}
