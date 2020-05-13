package com.example.parking.ui.signup;

import android.util.Log;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.Address;
import com.example.parking.domain.Rating;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;
import com.example.parking.util.Credits;
import com.example.parking.util.ZipCode;

import java.util.ArrayList;

public class SignUpPresenter {
    private SignUpView view;
    private UserDAO dao;
    SignUpPresenter(SignUpView view, UserDAO dao){
        this.view=view;
        this.dao=dao;
    }
    void add(){
        Address address = new Address(view.getStreet(),view.getStrN(),new ZipCode(Integer.valueOf(view.getZipCode())));
        User user = new User(view.getName(),view.getSurname(),view.getPhone(),view.getEmail(),view.getUsername(),view.getPassword(),new Credits(10),address,new ArrayList<Rating>(),new ArrayList<Vehicle>());
        dao.save(user);
        User us = dao.find(user.getUsername());
        Log.d("FIND user", us.toString());
        Log.e("user",user.toString());
        view.successfullyFinishActivity("registered");
    }
}
