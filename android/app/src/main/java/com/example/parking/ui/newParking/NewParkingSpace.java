package com.example.parking.ui.newParking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.parking.R;
import java.util.ArrayList;

public class NewParkingSpace extends AppCompatActivity implements NewParkingView{
    ArrayList<String> plates = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_parking_space);
        plates.add("ZXQ2222");
        plates.add("ZKS2763");
        Spinner spinner = (Spinner) findViewById(R.id.CarChoice);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewParkingSpace.this,
                android.R.layout.simple_spinner_dropdown_item,plates);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
