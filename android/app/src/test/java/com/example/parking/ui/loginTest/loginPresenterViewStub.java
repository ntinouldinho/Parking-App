package com.example.parking.ui.LoginTest;
import android.os.Bundle;

import com.example.parking.ui.Login.LoginView;

public class LoginPresenterViewStub implements LoginView {
    String username,password,toast;

    public LoginPresenterViewStub(){
        username = password = toast ="";
    }

    @Override
    public void moveOn() {

    }

    @Override
    public void createToast(String text) {
        toast = text;
    }

    public String getToast() {
        return toast;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username=username;
    }

    public void setPassword(String pass) {
        this.password=pass;
    }
    @Override
    public void signup() {

    }

}
