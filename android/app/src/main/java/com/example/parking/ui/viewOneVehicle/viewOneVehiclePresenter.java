package com.example.parking.ui.viewOneVehicle;

import android.graphics.Color;
import android.util.Log;
import android.widget.Toast;

import com.example.parking.dao.UserDAO;
import com.example.parking.domain.User;
import com.example.parking.domain.Vehicle;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.util.Colour;

import java.util.ArrayList;
import java.util.List;

public class viewOneVehiclePresenter {
    private viewOneVehicleView view;
    private Vehicle vehicle=null;
    private User user;
    private UserDAO dao;
    public List<String> users = new ArrayList<>();

    public viewOneVehiclePresenter(viewOneVehicleView view, UserDAO dao){
        this.view=view;
        this.dao=dao;
        user = dao.find(view.getUserName());
        if(view.getPlate()!=null){ //edit mode
            vehicle = dao.findVehicle(view.getUserName(),view.getPlate());
            decide();
            showInfo();
        }

        for(User author : dao.findAll()) users.add(author.getUsername());
        //view.setUsersList(users);
    }




    public void showInfo(){
        view.setBrand(vehicle.getBrand());
        view.setModel(vehicle.getModel());
        view.setPlate(vehicle.getPlate());
        view.setLength(vehicle.getLength());
        view.setText(vehicle.getText());
    }

    public void decide(){
        String brand = view.getBrand(),
                model=view.getModel(),
                plate = view.getPlateText(),
                text = view.getText();
        int length = view.getLength();
        int c=0;
        if(brand.length() < 3 || brand.length() > 15){
            view.showErrorMessage("Error!", "Brand must be more than 3 characters and up to 15.");
        }
        if(model.length() < 3 || model.length() > 15){
            view.showErrorMessage("Error!", "Model must be more than 3 characters and up to 15.");
        }
        if(length < 100 || length > 5000){
            view.showErrorMessage("Error!", "Length must be more than 100cm(1M) or less than 5000cm(500M).");
        }

       if(plate.length()!=7){
           view.showErrorMessage("Error!", "Plate must begin with 3 latin letter and then 4 numbers.");
       }

        if(text.length() < 5 || text.length() > 50){
            view.showErrorMessage("Error!", "Text must be more than 5 characters and up to 50.");
        }

        if(text.length() < 5 || text.length() > 50){
            view.showErrorMessage("Error!", "Text must be more than 5 characters and up to 50.");
        }


        if(c==0) {
            if (vehicle == null) {
                addVehicle();
                view.successfullyFinishActivity("Added Vehicle");
            } else {
                updateVehicle(brand, model, plate, length, text);
                view.successfullyFinishActivity("Updated Vehicle");
            }
        }

    }

    public boolean checkPlate(String plate){
        if(plate!=null) {
            String letters = plate.substring(0, 3).toUpperCase();

            for (int i = 0; i < letters.length(); i++) {
                char letter = letters.charAt(i);
                if (letter < 65 || letter > 90) ;
                return false;
            }
            String numbers = plate.substring(3);
            for (int i = 0; i < numbers.length(); i++) {
                int number = Integer.valueOf(numbers.charAt(i));
                if (number < 48 || number > 57) ;
                return false;
            }
            if (letters.length() + numbers.length() != 7) {
                return false;
            }
            return true;
        }
        return false;
    }


    public void addVehicle(){

        users.updateVehicle(view.getUserName(),new Vehicle(Colour.Blue,vehicle.getLength(),vehicle.getText(),vehicle.getPlate(),vehicle.getModel(),vehicle.getBrand()));
        view.successfullyFinishActivity("Vehicle with plate"+ vehicle.getPlate() +" added");
    }

    public void updateVehicle(String brand,String model,String plate, int length,String text){
        Vehicle temp = dao.find(view.getUserName()).getVehicle(plate);
        temp.setBrand(view.getBrand());
        temp.setModel(view.getModel());
        temp.setLength(view.getLength());
        temp.setText(view.getText());
        dao.updateVehicle(user.getUsername(),temp);
        view.successfullyFinishActivity("Vehicle with plate"+ vehicle.getPlate() +" updated");
    }
}
