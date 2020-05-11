package com.example.parking.ui.homescreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.parking.ui.newParking.NewParkingSpace;
import com.example.parking.R;
import com.example.parking.ui.viewUser.UserProfile;
import com.example.parking.ui.viewVehicle.ViewVehicles;

public class HomeScreenActivity extends AppCompatActivity {
    Button parkingSpace;
    Button request;
    Button profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        parkingSpace = (Button) findViewById(R.id.submit);
        request = (Button) findViewById(R.id.request);
        profile = (Button) findViewById(R.id.profile);

        parkingSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeScreenActivity.this, NewParkingSpace.class);
                startActivity(myIntent);
            }
        });
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeScreenActivity.this, ViewVehicles.class);
                startActivity(myIntent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeScreenActivity.this, UserProfile.class);
                startActivity(myIntent);
            }
        });

    }
}
