package com.example.parking.ui.viewUser;

public interface UserProfileView {
    void setCredits(int credits);
    int getCredits();
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

    void successfullyFinishActivity(String message);

    void setIntentUsername(String username);

    String getIntentUsername ();

    String getErrorTitle();
    String getFinishMessage();
    String getErrorMessage();
    void showErrorMessage(String title, String message);
}
