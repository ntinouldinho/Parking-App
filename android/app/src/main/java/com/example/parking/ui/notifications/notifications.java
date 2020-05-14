package com.example.parking.ui.notifications;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parking.R;
import com.example.parking.domain.ParkingRequest;
import com.example.parking.domain.ParkingSpace;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.util.Pin;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class notifications extends AppCompatActivity implements notificationView{
    notificationsPresenter presenter;
    ArrayList<Button> awaitingForYourApproval = new ArrayList<>();
    ArrayList<Button> enterPin = new ArrayList<>();
    ArrayList<ParkingRequest> reqsForPin = new ArrayList<>();
    int i=0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        presenter = new notificationsPresenter(this, MemoryInitializer.getRequestDAO(),MemoryInitializer.getUserDAO());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ArrayList<Button> showNotifications(ArrayList<ParkingRequest> all, String username){
        int colorBackground = Color.parseColor("#337FFF");
        int colorText = Color.parseColor("#ffffff");


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

            btn.setTextSize(12);
            btn.setTextColor(colorText);
            btn.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200));


            if(request.getParkingSpace().getParkedUser().getUsername().equals(username) && request.getPin()==null){

            }
            if(request.getRequestingUser().getUsername().equals(username)){
                if(request.getPin()!=null) {
                    not = "Awaiting for approval";  //notification only
                }else{
                    if(request.getDate()==null){
                        not = "Request rejected"; //notification only
                    }else {
                        not = "Awaiting for your arrival"; //notification only with pin display
                    }
                }
            }else if(request.getParkingSpace().getParkedUser().getUsername().equals(username)){
                if(request.getPin()!=null) {
                    enterPin.add(btn);
                    reqsForPin.add(request);
                    Log.e("test req",request.toString());
                    not = "Awaiting for arrival"; //button, when pressed pin must be entered
                }else{
                    if(request.getDate()==null){
                        not = "Request rejected"; //notification only
                    }else {
                        awaitingForYourApproval.add(btn);
                        not = "Awaiting for your approval";
                    }

                }
            }
            btn.setText(not);
            newLayout.addView(btn);
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
        enterPinListener(enterPin,reqsForPin);
        return awaitingForYourApproval;
    }

    public void makeToast(String m){
        Toast.makeText(this,m, Toast.LENGTH_SHORT).show();
    }

    public String getUserName()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }

    public ArrayList<ParkingRequest> getReqs(){ return reqsForPin;}
    int y=0;
    public void enterPinListener(ArrayList<Button> myButtons,ArrayList<ParkingRequest> reqs) {
        //get switch
        Log.e("in", String.valueOf(myButtons.size()));
        for(int i=0;i<myButtons.size();i++){
            y=i;
            Log.e("in","in "+i);
            Button b = myButtons.get(i);
            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(notifications.this);
                            builder.setMessage("Test for preventing dialog close");
                            builder.setPositiveButton("Confirm",
                                    new DialogInterface.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which)
                                        {

                                        }
                                    });
                            builder.setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener()
                                    {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which)
                                        {
                                            dialog.dismiss();
                                        }
                                    });
                            final EditText input = new EditText(notifications.this);
                            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            builder.setView(input);
                            AlertDialog dialog = builder.create();

                            dialog.show();
                            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
                            {
                                @RequiresApi(api = Build.VERSION_CODES.O)
                                @Override
                                public void onClick(View v)
                                {
                                    Boolean wantToCloseDialog = false;
                                    int k=y;
                                    //Do stuff, possibly set wantToCloseDialog to true then...
                                    if(Integer.valueOf(input.getText().toString())==5555) {
                                        Log.e("the i", String.valueOf(k));
                                        presenter.validateParking(reqsForPin.get(k),new Pin(Integer.valueOf(input.getText().toString())));
                                        dialog.dismiss();
                                    }else{
                                        makeToast(input.getText().toString()+" is the wrong pin");
                                    }
                                    //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.
                                }
                            });

                        }
                    });
        }
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

                            builder.setTitle("Pin");
                            builder.setMessage("The requesting user has arrived. Enter the pin he has given you.");

                            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // validate parking

                                    dialog.dismiss();
                                }
                            });

                            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    // date null

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
