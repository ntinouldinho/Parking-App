package com.example.parking.ui.showParkingSpace;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.parking.R;
import com.example.parking.dao.ParkingSpaceDAO;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.homescreen.HomeScreenActivity;
import com.google.gson.Gson;

public class ShowParkingSpace extends AppCompatActivity implements ShowParkingView {

    ShowParkingPresenter presenter;
    ParkingSpace parkingSpace;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_parking);
       Gson gson = new Gson();
        String parkingSpaceAsAString = getIntent().getStringExtra("parkingSpace");

        parkingSpace = gson.fromJson(parkingSpaceAsAString, ParkingSpace.class);
        Log.e("show",parkingSpace.toString());
        presenter = new ShowParkingPresenter(this, MemoryInitializer.getUserDAO(), MemoryInitializer.getParkingDAO(),MemoryInitializer.getRequestDAO(),parkingSpace);

        Button btn = (Button) findViewById(R.id.sendParkingRequest);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                presenter.add(parkingSpace);

            }
        });

    }
    public String getRequestingUser() { return this.getIntent().hasExtra("Username") ? this.getIntent().getExtras().getString("Username") : null; }
    public void setRating(String ratingScore) { ((TextView) findViewById(R.id.ReviewsOfParkedUser)).setText(ratingScore);}
    public void setParkedUser(String parkedUsername){ ((TextView) findViewById(R.id.ParkedUser)).setText(parkedUsername);}
    public void setVehicle(String plate){((TextView) findViewById(R.id.ParkedVehicle)).setText(plate);}
    public void setAddress(String zip){((TextView) findViewById(R.id.AddressForRequest)).setText(zip); }
}
