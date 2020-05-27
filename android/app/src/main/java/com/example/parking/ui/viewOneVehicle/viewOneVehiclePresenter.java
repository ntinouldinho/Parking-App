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


    /**
     * Αρχικοποεί τον Presenter.
     * @param view Ένα instance του view
     * @param dao Ένα instance του user
     */
    public viewOneVehiclePresenter(viewOneVehicleView view, UserDAO dao){
        this.view=view;
        this.dao=dao;
        user = dao.find(view.getUserName());

        if(view.getPlate()!=null){ //edit mode

            vehicle = dao.findVehicle(view.getIntentUsername(),view.getIntentPlate());
            showInfo();

        }
    }


    /**
     * Εμφανίζει τα αποθηκευμένα πεδία του vehicle.
     */

    public void showInfo(){
        view.setBrand(vehicle.getBrand());
        view.setModel(vehicle.getModel());
        view.setPlate(vehicle.getPlate());
        view.setLength(vehicle.getLength());
        view.setText(vehicle.getText());
    }

    /**
     * Ελέγχει το vehicle για αποθήκευση ή προσθήκη.
     */
    public void decide(){
        String brand = view.getBrand(),
                model=view.getModel(),
                plate = view.getPlate(),
                text = view.getText();
        int length = view.getLength();

        if(!checkPlate(plate)) {
            view.showErrorMessage("plates", "Plate must begin with 3 latin letter and then 4 numbers.");
            view.successfullyFinishActivity(plate);
        }else if(brand.length() < 3 || brand.length() > 15){
            view.showErrorMessage("brand", "Brand must be more than 3 characters and up to 15.");
            view.successfullyFinishActivity(brand);
        }else if(model.length() < 3 || model.length() > 15){
            view.showErrorMessage("model", "Model must be more than 3 characters and up to 15.");
            view.successfullyFinishActivity("plat2");
        }else if(length < 100 || length > 5000){
            view.showErrorMessage("length", "Length must be more than 100cm(1M) or less than 5000cm(500M).");
            view.successfullyFinishActivity("plat3");
        }else if(text.length() < 5 || text.length() > 50){
            view.showErrorMessage("text", "Text must be more than 5 characters and up to 50.");
            view.successfullyFinishActivity("plat4");
        }else {


            if (vehicle == null) {
                addVehicle();
                view.successfullyFinishActivity("Vehicle with plate" + view.getIntentPlate() + " added");
            } else {
                updateVehicle(brand, model, plate, length, text);
                view.successfullyFinishActivity("Vehicle with plate" + view.getIntentPlate() + " updated");
            }
        }
    }


    /**
     * Ελέγχει την πινακίδα.
     * @param plate Η πινακίδα.
     */
    public boolean checkPlate(String plate){
        if(plate!=null) {
            String letters = plate.substring(0, 3).toUpperCase();

            for (int i = 0; i < letters.length(); i++) {
                char letter = letters.charAt(i);
                if (letter < 65 || letter > 90)
                return false;
            }
            String numbers = plate.substring(3);
            for (int i = 0; i < numbers.length(); i++) {
                int number = Integer.valueOf(numbers.charAt(i));
                if (number < 48 || number > 57)
                return false;
            }
            if (letters.length() + numbers.length() != 7) {
                return false;
            }
            return true;
        }
        return false;
    }


    /**
     * Προσθέτει ένα vehicle.
     */
    public void addVehicle(){

        dao.updateVehicle(view.getIntentUsername(),new Vehicle(view.getColour(),view.getLength(),view.getText(),view.getPlate(),view.getModel(),view.getBrand()));
        view.successfullyFinishActivity("Vehicle with plate"+ view.getPlate() +" added");
    }

    /**
     * Ενημερώνει ένα ήδη υπάρχον vehicle.
     * @param brand Η μάρκα
     * @param model Το μοντέλο
     * @param length Το μήκος
     * @param text  Η περγιγραφή
     */
    public void updateVehicle(String brand,String model,String plate, int length,String text){
        Vehicle temp = dao.find(view.getIntentUsername()).getVehicle(plate);
        temp.setBrand(view.getBrand());
        temp.setModel(view.getModel());
        temp.setLength(view.getLength());
        temp.setText(view.getText());
        dao.updateVehicle(user.getUsername(),temp);
        view.successfullyFinishActivity("Vehicle with plate"+ vehicle.getPlate() +" updated");
    }
}
