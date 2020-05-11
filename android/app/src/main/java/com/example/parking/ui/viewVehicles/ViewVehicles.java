package com.example.parking.ui.viewVehicles;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.parking.R;
import com.example.parking.domain.Vehicle;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.addVehicle.AddVehicle;
import com.example.parking.ui.viewOneVehicle.viewOneVehicle;
import com.example.parking.util.Colour;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class ViewVehicles extends AppCompatActivity implements ViewVehiclesView {
    private ViewVehiclesPresenter presenter;
    Vehicle currentVehicle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicles);
        presenter = new ViewVehiclesPresenter(this, MemoryInitializer.getUserDAO());


        Log.e("ot","wwwwwwwwww");
    }


    public String getUserName()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }

    public ArrayList<Button> showVehicles(ArrayList<Vehicle> DaoVehicles){
        int colorBackground = Color.parseColor("#337FFF");
        int colorText = Color.parseColor("#ffffff");


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
        for (int i = 0; i < DaoVehicles.size(); i++) {
            // create a new textview
            // Create LinearLayout
            LinearLayout newLayout = new LinearLayout(this);
            newLayout.setOrientation(LinearLayout.VERTICAL);
            newLayout.setBackgroundColor(colorBackground);
            Vehicle veh = DaoVehicles.get(i);
            // Add title
            // Create Button
            final Button btn = new Button(this);
            btn.setBackgroundColor(colorBackground);
            btn.setText(veh.getBrand() + " "+ veh.getModel());
            btn.setTextSize(12);
            btn.setTextColor(colorText);
            btn.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100));
            newLayout.addView(btn);
            buttons.add(btn);
            //Add
            String info = veh.toString();
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

        return buttons;
    }

    public void setSongOnClickListener(ArrayList<Button> myButtons,ArrayList<Vehicle> DaoVehicles) {
        //get switch

        for(int i=0;i<myButtons.size();i++){
            Button b = myButtons.get(i);
            currentVehicle =DaoVehicles.get(i);
            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            viewOneVehicle(currentVehicle);

                        }
                    });
        }

    }

    public void viewOneVehicle(Vehicle vehicle){
        Intent myIntent = new Intent(ViewVehicles.this, viewOneVehicle.class);
        myIntent.putExtra("username", getUserName());

        myIntent.putExtra("plate", currentVehicle.getPlate());
        startActivityForResult(myIntent,1);
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
