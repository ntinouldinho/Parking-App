package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.parking.domain.Vehicle;
import com.example.parking.util.Colour;

import java.util.ArrayList;

public class ViewVehicles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicles);
        int colorBackground = Color.parseColor("#337FFF");
        int colorText = Color.parseColor("#ffffff");
        /* LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_view_vehicles, null);
        LinearLayout newLayout = v.findViewById(R.id.search_layout);
        // Create a LinearLayout element
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);

        // Add text
        TextView tv = new TextView(this);
        tv.setText("my text");
        ll.addView(tv);

        // Add the LinearLayout element to the ScrollView
        v.addView(ll);

        // Display the view
        setContentView(v);
        */
        Log.e("ot","wwwwwwwwww");

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_view_vehicles, null);
ArrayList<Button> buttons = new ArrayList<>();
        // Find the ScrollView
        LinearLayout sv = (LinearLayout) v.findViewById(R.id.search_layout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 0, 0, 30);

        // Create a LinearLayout element
        Vehicle vehicle = new Vehicle(Colour.Black,300,"nothing to say","XYZ4590","Focus","Ford");
        int padding = 30;
        for (int i = 0; i < 5; i++) {
            // create a new textview
            // Create LinearLayout
            LinearLayout newLayout = new LinearLayout(this);
            newLayout.setOrientation(LinearLayout.VERTICAL);
            newLayout.setBackgroundColor(colorBackground);

            // Add title
            // Create Button
            final Button btn = new Button(this);
            btn.setBackgroundColor(colorBackground);
            btn.setText(vehicle.getBrand() + " "+ vehicle.getModel());
            btn.setTextSize(12);
            btn.setTextColor(colorText);
            btn.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100));
            newLayout.addView(btn);
            buttons.add(btn);
            //Add
            String info = vehicle.toString();
            TextView data = new TextView(this);
            data.setText(info);
            data.setTextSize(10);
            data.setTextColor(colorText);
            newLayout.addView(data);

            newLayout.setLayoutParams(layoutParams);

            newLayout.setPadding(padding,padding,padding,padding);
            // add the textview to the linearlayout
            sv.addView(newLayout);

        }
        // Display the view
        setContentView(v);
        setSongOnClickListener(buttons);
        Log.e("ot","wwwwwwwwww");
    }

    public void setSongOnClickListener(ArrayList<Button> mySongs) {
        //get switch

        for(Button b: mySongs){
            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            startActivity(new Intent(ViewVehicles.this, MakeParkingRequest.class));

                        }
                    });
        }

    }
}
