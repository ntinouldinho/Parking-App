package com.example.parking.ui.viewUser;

public interface UserProfileView {
    void setCredits(int credits);
    String getCredits();
    String getFirstName();
    void setFirstName(String value);
    String getLastName();
    void setLastName(String value);
    String getEmail();
    void setEmail(String value);
    String getZip();
    void setZip(String value);
    String getStreet();
    void setStreet(String value);
    String getStreetNo();
    void setStreetNo(String value);
    String getPhone();
    void setPhone(String value);
    String getUsername();
    void addClickListeners();
}
