package com.example.parking.ui.login;

import com.example.parking.ui.login.LoginView;
import com.example.parking.dao.UserDAO;
import com.example.parking.domain.User;

public class LoginPresenter {
    private LoginView view;
    private UserDAO dao;

    public LoginPresenter(LoginView view, UserDAO dao){
        this.view=view;
        this.dao=dao;
    }

    public void login(){
        User user =  dao.login(view.getUsername(),view.getPassword());
        if(user!=null){
            view.createToast("Logged in");
            view.moveOn();
        }else{
            view.createToast("Wrong username or password");
        }
    }

    public void signup(){
        view.signup();
    }
}
