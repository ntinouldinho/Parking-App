package com.example.parking.ui.notifications;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parking.R;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.memorydao.MemoryInitializer;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class notifications extends AppCompatActivity implements notificationView{
    notificationsPresenter presenter;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        presenter = new notificationsPresenter(this, MemoryInitializer.getRequestDAO());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<Button> showNotifications(ArrayList<ParkingRequest> all, String username){
        int colorBackground = Color.parseColor("#337FFF");
        int colorText = Color.parseColor("#ffffff");

        ArrayList<Button> awaitingForYourApproval = new ArrayList<>();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_notifications, null);
        // Find the ScrollView
        LinearLayout sv = (LinearLayout) v.findViewById(R.id.notification);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, 30);
        String not="";
        // Create a LinearLayout element
        //Vehicle vehicle = new Vehicle(Colour.Black,300,"nothing to say","XYZ4590","Focus","Ford");
        int padding = 30;
        for (int i = 0; i < all.size(); i++) {
            ParkingRequest request = all.get(i);
            if(request.getRequestingUser().getUsername().equals(username)){
                if(request.getPin()!=null) {
                    not = "Awaiting for approval";
                }else{
                    not = "Awaiting for your arrival";
                }
            }else if(request.getParkingSpace().getParkedUser().getUsername().equals(username)){
                if(request.getPin()!=null) {
                    not = "Awaiting for your approval";
                }else{
                    not = "Awaiting for arrival";
                }
            }
            Log.e("PARKINGSPACEDAOSIZE",String.valueOf(i));
            // create a new textview
            // Create LinearLayout
            LinearLayout newLayout = new LinearLayout(this);
            newLayout.setOrientation(LinearLayout.VERTICAL);
            newLayout.setBackgroundColor(colorBackground);
            // Add title
            // Create Button
            final Button btn = new Button(this);
            btn.setBackgroundColor(colorBackground);
            btn.setText(not);
            btn.setTextSize(12);
            btn.setTextColor(colorText);
            btn.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200));
            newLayout.addView(btn);

            if(request.getParkingSpace().getParkedUser().getUsername().equals(username) && request.getPin()==null){
                awaitingForYourApproval.add(btn);
            }
            //Add
            TextView data = new TextView(this);
            data.setText("okk");
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

        return awaitingForYourApproval;
    }

    public void makeToast(String m){
        Toast.makeText(this,m, Toast.LENGTH_SHORT).show();
    }

    public String getUserName()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }

    public void setParkingOnClickListener(ArrayList<Button> myButtons) {
        //get switch
Log.e("in", String.valueOf(myButtons.size()));
        for(int i=0;i<myButtons.size();i++){
            Log.e("in","in");
            Button b = myButtons.get(i);
            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(notifications.this);

                            builder.setTitle("Confirm");
                            builder.setMessage("Do you want to accept this request?Are you sure?");

                            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // Do nothing but close the dialog

                                    dialog.dismiss();
                                }
                            });

                            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    // Do nothing
                                    dialog.dismiss();
                                }
                            });

                            AlertDialog alert = builder.create();
                            alert.show();

                        }
                    });
        }
    }
}
