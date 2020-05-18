package com.example.parking.ui.viewOneVehicle;

import com.example.parking.util.Colour;

public interface viewOneVehicleView {
    void setBrand(String value);
    String getBrand();

    void setModel(String value);
    String getModel();

    void setPlate(String value);
    String getPlateText();

    void setLength(int value);
    int getLength();

    void setText(String value);
    String getText();

    Colour getColour();

    String getUserName();

    String getPlate();

    void successfullyFinishActivity(String value);
    String getErrorTitle();
    String getFinishMessage();
    String getErrorMessage();
    void showErrorMessage(String title, String message);

    void setIntentUsername(String username);
    String getIntentUsername ();


    void setIntentPlate(String plate);
    String getIntentPlate ();
}
