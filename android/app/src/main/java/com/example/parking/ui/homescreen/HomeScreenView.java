package com.example.parking.ui.homescreen;

public interface HomeScreenView {
    void spaceIntent();
    void requestIntent();
    void profileIntent();
    void notificationIntent();
    String getUserName();
    void makeToast(String m);
}
