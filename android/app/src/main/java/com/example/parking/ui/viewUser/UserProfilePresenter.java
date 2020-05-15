package com.example.parking.ui.viewUser;

import android.util.Log;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.Address;
import com.example.parking.domain.User;
import com.example.parking.util.Credits;
import com.example.parking.util.ZipCode;

public class UserProfilePresenter {
    private UserProfileView view;
    private UserDAO dao;
    private User currentUser;
    UserProfilePresenter(UserProfileView view,UserDAO dao){
        this.view=view;
        this.dao=dao;
        currentUser = dao.find(view.getUsername());
        Log.e("reqqq",currentUser.toString());
        setFields();
        addListeners();
    }

    private void addListeners() {
        view.addClickListeners();
    }

    void setFields() {
        view.setFirstName(currentUser.getName());
        view.setLastName(currentUser.getSurname());
        view.setEmail(currentUser.getEmail());
        view.setCredits(currentUser.getCredits().getPoints());
        view.setStreet(currentUser.getAddress().getStreet());
        view.setStreetNo(currentUser.getAddress().getStreetNumber());
        view.setZip(String.valueOf(currentUser.getAddress().getZipCode().getZip()));
        view.setPhone(currentUser.getPhone());
    }

    void update(){
        Address currentAddress = currentUser.getAddress();
        currentAddress.setStreet(view.getStreet());
        currentAddress.setStreetNumber(view.getStreetNo());
        currentAddress.setZipCode(new ZipCode(Integer.valueOf(view.getZip())));
        User newUser = new User(view.getFirstName(),view.getLastName(),view.getPhone(),view.getEmail(),currentUser.getUsername(),currentUser.getPassword(),new Credits(Integer.parseInt(view.getCredits())),currentAddress,currentUser.getRating(),currentUser.getVehicles());
        dao.update(newUser,currentUser.getUsername());
    }
}
