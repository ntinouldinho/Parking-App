package com.example.parking.ui.HomeScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parking.R;
import com.example.parking.ui.FindParking.FindParking;
import com.example.parking.ui.Notifications.Notifications;
import com.example.parking.ui.NewParking.NewParkingSpace;
import com.example.parking.ui.ViewUser.UserProfile;

public class HomeScreenActivity extends AppCompatActivity {
    Button parkingSpace;
    Button request;
    Button profile;
    Button notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        parkingSpace = (Button) findViewById(R.id.submit);
        request = (Button) findViewById(R.id.request);
        profile = (Button) findViewById(R.id.profile);
        notification = (Button) findViewById(R.id.notification);
        parkingSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeScreenActivity.this, NewParkingSpace.class);
                myIntent.putExtra("username",getUserName());
                startActivity(myIntent);
            }
        });
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeScreenActivity.this, FindParking.class);
                myIntent.putExtra("username", getUserName());
                startActivity(myIntent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeScreenActivity.this, UserProfile.class);
                myIntent.putExtra("username", getUserName());
                startActivity(myIntent);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeScreenActivity.this, Notifications.class);
                myIntent.putExtra("username", getUserName());
                startActivity(myIntent);
            }
        });

    }

    public String getUserName()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            recreate();
            Toast.makeText(this,data.getStringExtra("message_to_toast"),Toast.LENGTH_SHORT).show();
        }
        else if(requestCode == 100)
            recreate();
    }
}
