package com.example.parking.ui.findParking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.parking.R;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.domain.Vehicle;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.viewOneVehicle.viewOneVehicle;
import com.example.parking.ui.viewVehicles.ViewVehicles;
import com.example.parking.util.Colour;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class findParking extends AppCompatActivity implements findParkingView{
    findParkingPresenter presenter;
    String zipcode;
    EditText ZipCodeEditText;
    ParkingSpace parking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_parking);
        presenter = new findParkingPresenter(this, MemoryInitializer.getUserDAO(),MemoryInitializer.getParkingDAO());

        ImageButton btn = (ImageButton) findViewById(R.id.SearchButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(validateZipcode()) {
                    presenter.find();
                    makeToast(getZip());
                }
            }
        });
    }

    public String getZip(){
        return ((EditText) findViewById(R.id.ZipForParking)).getText().toString();
    }

    private boolean validateZipcode(){
        zipcode = getZip().trim();
        ZipCodeEditText = (EditText)findViewById(R.id.ZipForParking);
        if(zipcode.isEmpty()){
            ZipCodeEditText.setError("ZipCode cannot be empty");
            return false;
        }else if(zipcode.length()!=5){
            ZipCodeEditText.setError("ZipCode must be 5 digits");
            return false;
        }else{
            ZipCodeEditText.setError(null);
            Toast.makeText(this,"ZipCode added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<Button> showParkingSpace(ArrayList<ParkingSpace> DaoParkingSpace){
        int colorBackground = Color.parseColor("#337FFF");
        int colorText = Color.parseColor("#ffffff");


        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_find_parking, null);
        ArrayList<Button> buttons = new ArrayList<>();
        // Find the ScrollView
        LinearLayout sv = (LinearLayout) v.findViewById(R.id.ResultsList);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 30);

        // Create a LinearLayout element
        //Vehicle vehicle = new Vehicle(Colour.Black,300,"nothing to say","XYZ4590","Focus","Ford");
        int padding = 30;
        for (int i = 0; i < DaoParkingSpace.size(); i++) {
            Log.e("PARKINGSPACEDAOSIZE",String.valueOf(DaoParkingSpace.size()));
            // create a new textview
            // Create LinearLayout
            LinearLayout newLayout = new LinearLayout(this);
            newLayout.setOrientation(LinearLayout.VERTICAL);
            newLayout.setBackgroundColor(colorBackground);
            ParkingSpace p = DaoParkingSpace.get(i);
            // Add title
            // Create Button
            final Button btn = new Button(this);
            btn.setBackgroundColor(colorBackground);
            btn.setText(p.getAddress().toString() + " "+ p.getParkedUser().getUsername());
            btn.setTextSize(12);
            btn.setTextColor(colorText);
            btn.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 200));
            newLayout.addView(btn);
            buttons.add(btn);
            //Add
            String info =  p.getParkedUser().getUsername();
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

    public void makeToast(String m){
        Toast.makeText(this,m, Toast.LENGTH_SHORT).show();
    }


    public void setParkingOnClickListener(ArrayList<Button> myButtons) {
        //get switch

        for(int i=0;i<myButtons.size();i++){
            Button b = myButtons.get(i);
            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            viewOneVehicle();

                        }
                    });
        }
    }

    public void viewOneVehicle(){
        Log.e("in","ok");
    }

}
