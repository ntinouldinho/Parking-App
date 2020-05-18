package com.example.parking.ui.login;

import android.os.Bundle;

public interface LoginView {
    void moveOn();
    void createToast(String text);
    String getUsername();
    String getPassword();
    void signup();
}
