package com.example.parking.ui.viewVehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.wifi.WifiManager;
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
import com.example.parking.ui.addVehicle.AddVehicle;
import com.example.parking.util.Colour;

import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class ViewVehicles extends AppCompatActivity {
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Vehicle currentVehicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicles);
        int colorBackground = Color.parseColor("#337FFF");
        int colorText = Color.parseColor("#ffffff");

        Log.e("ot",wifiIpAddress(this));
        Toast.makeText(getApplicationContext(),wifiIpAddress(this),Toast.LENGTH_LONG).show();
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_view_vehicles, null);
ArrayList<Button> buttons = new ArrayList<>();
        // Find the ScrollView
        LinearLayout sv = (LinearLayout) v.findViewById(R.id.search_layout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 0, 0, 30);

        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        Log.e("my ip",ip);

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
            vehicles.add(vehicle);
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

    public void setSongOnClickListener(ArrayList<Button> myButtons) {
        //get switch

        for(int i=0;i<myButtons.size();i++){
            Button b = myButtons.get(i);
            currentVehicle = vehicles.get(i);
            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            Intent myIntent = new Intent(ViewVehicles.this, AddVehicle.class);
                            myIntent.putExtra("mode", "edit");
                            myIntent.putExtra("model", currentVehicle.getModel());
                            myIntent.putExtra("brand", currentVehicle.getBrand());
                            myIntent.putExtra("plate", currentVehicle.getPlate());
                            myIntent.putExtra("colour", currentVehicle.getColour());
                            myIntent.putExtra("length", currentVehicle.getLength());
                            myIntent.putExtra("text", currentVehicle.getText());
                            startActivity(myIntent);

                        }
                    });
        }

    }

    protected String wifiIpAddress(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();

        // Convert little-endian to big-endianif needed
        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN)) {
            ipAddress = Integer.reverseBytes(ipAddress);
        }

        byte[] ipByteArray = BigInteger.valueOf(ipAddress).toByteArray();

        String ipAddressString;
        try {
            ipAddressString = InetAddress.getByAddress(ipByteArray).getHostAddress();
        } catch (UnknownHostException ex) {
            Log.e("WIFIIP", "Unable to get host address.");
            ipAddressString = null;
        }

        return ipAddressString;
    }
}
