package com.example.parking.ui.findParking;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
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

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.parking.R;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.showParkingSpace.ShowParkingSpace;
import com.google.gson.Gson;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class findParking extends AppCompatActivity implements findParkingView{
    ArrayList<ParkingSpace> spaces = new ArrayList<>();
    findParkingPresenter presenter;
    String zipcode;
    LocalDateTime expectedArrivalDateTime;
    EditText ZipCodeEditText, expectedArrival;
    ParkingSpace parking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_parking);
        presenter = new findParkingPresenter(this, MemoryInitializer.getUserDAO(),MemoryInitializer.getParkingDAO());

        expectedArrival = (EditText) findViewById(R.id.expectedArrivalFindParking);
        ImageButton btn = (ImageButton) findViewById(R.id.SearchButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(expectedArrival.getText().toString().trim().length() == 0){
                    expectedArrival.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                    return;
                }else{
                    expectedArrival.setBackgroundResource(android.R.drawable.edit_text);
                    expectedArrivalDateTime = LocalDateTime.now().plusMinutes(Integer.parseInt(expectedArrival.getText().toString()));
                }
                presenter.find();
                makeToast(getZip());
            }
        });
    }

    public LocalDateTime getExpectedArrivalDateTime(){
        return expectedArrivalDateTime;
    }

    public String getZip(){
        return ((EditText) findViewById(R.id.ZipForParking)).getText().toString();
    }


    public void setErrorToZip(String error){
        ((EditText)findViewById(R.id.ZipForParking)).setError(error);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showParkingSpace(ArrayList<ParkingSpace> DaoParkingSpace){
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
            String details = p.getAddress().toString() + " "+ p.getParkedUser().getUsername() +
                    " " + p.getTimeRange();
            btn.setText(details);
            btn.setTextSize(11);
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
            setParkingOnClickListener(btn,p);
        }
        // Display the view
        setContentView(v);

    }

    public void makeToast(String m){
        Toast.makeText(this,m, Toast.LENGTH_SHORT).show();
    }

    public void setParkingOnClickListener(Button b,ParkingSpace parkspa) {
        //get switch
        b.setOnClickListener(
                    new View.OnClickListener()
                    {

                        @RequiresApi(api = Build.VERSION_CODES.O)

                        public void onClick(View view)
                        {
                            Gson gson = new Gson();
                            String parkingSpaceAsAString = gson.toJson(parkspa);
                            Intent myIntent = new Intent(findParking.this, ShowParkingSpace.class);
                            myIntent.putExtra("Username", getUserName());
                            myIntent.putExtra("parkingSpace",parkingSpaceAsAString);
                            startActivity(myIntent);

                        }
                    });

    }


    public String getUserName()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String flag=getIntent().hasExtra("CodeForRestart") ? getIntent().getExtras().getString("CodeForRestart") : "bad";
        if(flag.equals("OK")){
            recreate();
        }

    }


}
