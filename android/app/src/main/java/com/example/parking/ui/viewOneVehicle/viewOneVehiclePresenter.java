package com.example.parking.ui.viewOneVehicle;

import android.graphics.Color;
import android.util.Log;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.util.Colour;

public class viewOneVehiclePresenter {
    private viewOneVehicleView view;
    private Vehicle vehicle=null;
    private User user;
    private UserDAO dao;

    viewOneVehiclePresenter(viewOneVehicleView view, UserDAO dao){
        this.view=view;
        this.dao=dao;
        user = dao.find(view.getUserName());
        if(view.getPlate()!=null){ //edit mode
            vehicle = dao.findVehicle(view.getUserName(),view.getPlate());
            showInfo();
        }

    }
    void showInfo(){
        view.setBrand(vehicle.getBrand());
        view.setModel(vehicle.getModel());
        view.setPlate(vehicle.getPlate());
        view.setLengthText(vehicle.getLength());
        view.setText(vehicle.getText());
    }

    void decide(){
        String brand = view.getBrand(),model=view.getModel(),plate = view.getPlateText(),length = view.getLength(),text = view.getText();
        if (vehicle == null) {
            addVehicle(brand,model,plate,length,text);
            view.successfullyFinishActivity("added");
        } else {
            updateVehicle(brand,model,plate,length,text);
            view.successfullyFinishActivity("updated");
        }
    }

    void addVehicle(String brand,String model,String plate, String length,String text){
        dao.find(view.getUserName()).addVehicle(new Vehicle(Colour.Black,Integer.parseInt(length),text,plate,model,brand));
    }

    void updateVehicle(String brand,String model,String plate, String length,String text){
        Vehicle temp = dao.find(view.getUserName()).getVehicle(plate);
        temp.setBrand(brand);
        temp.setModel(model);
        temp.setLength(Integer.parseInt(length));
        temp.setText(text);
        dao.updateVehicle(user.getUsername(),temp);
    }
}
