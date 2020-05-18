package com.example.parking.ui.viewVehicles;

import android.os.Bundle;
import android.widget.Button;

import com.example.parking.domain.Vehicle;

import java.util.ArrayList;

public interface ViewVehiclesView {
    String getUserName();
    void setIntentUsername(String username);
    String getIntentUsername ();
}
