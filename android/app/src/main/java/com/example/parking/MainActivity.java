package com.example.parking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.parking.domain.ParkingRequest;
import com.example.parking.memorydao.MemoryInitializer;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MemoryInitializer.prepareData();
        Log.e("test", String.valueOf(MemoryInitializer.getParkingDAO().findAll().get(0).toString()));
//        Intent myIntent = new Intent(this, HomeScreenActivity.class);
//        startActivity(myIntent);
    }
}
