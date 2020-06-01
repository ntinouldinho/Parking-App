package com.example.parking.ui.Notifications;

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

public class Notifications extends AppCompatActivity implements NotificationsView{
    NotificationsPresenter presenter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        presenter = new NotificationsPresenter(this, MemoryInitializer.getRequestDAO(),MemoryInitializer.getUserDAO());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showNotifications(ArrayList<ParkingRequest> all, String username){
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
            // Add title
            // Create Button
            newLayout.setBackgroundColor(colorBackground);
            final Button btn = new Button(this);
            btn.setBackgroundColor(colorBackground);

            btn.setTextSize(10);
            btn.setTextColor(Color.parseColor("#000000"));
            btn.setLayoutParams (new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100));

            TextView data = new TextView(this);
            data.setTextSize(10);
            data.setTextColor(colorText);

            if(request.getRequestingUser().getUsername().equals(username)){
                if(request.getPin()!=null) {

                    colorBackground=Color.parseColor("#22ff00");
                    data.setText("You have asked for a parking space at "+request.getParkingSpace().getAddress().getStreet()+", from: "+request.getDate().getFrom() + " to: "+request.getDate().getTo()+", your request is pending for:" + request.getParkingSpace().getParkedUser().getUsername());
                    not = "Pending request";  //notification only
                }else{
                    if(request.getDate()==null){

                        colorBackground=Color.parseColor("#ff0000");
                        data.setText(request.getDate().toString() + ", your request iwas rejected from:" + request.getParkingSpace().getParkedUser().getUsername());
                        not = "Your request has been rejected"; //notification only
                    }else {

                        data.setText(request.getDate().toString() + ", your request is accepted from:" + request.getParkingSpace().getParkedUser().getUsername());
                        colorBackground=Color.parseColor("#22ff00");
                        not = "You have to go to"; //notification only with pin display
                    }
                }
            }else if(request.getParkingSpace().getParkedUser().getUsername().equals(username)){
                if(request.getPin()!=null) {

                    data.setText(request.getDate().toString() + ", your request is pending for:" + request.getRequestingUser().getUsername());
                    colorBackground=Color.parseColor("#22ff00");
                    enterPinListener(btn,request);
                    not = "Accepted.Awaiting for arrival"; //button, when pressed pin must be entered
                }else{
                    if(request.getDate()==null){
                        data.setText(request.getDate().toString() + ", your rejected a request from:" + request.getRequestingUser().getUsername());
                        colorBackground=Color.parseColor("#ff0000");
                        not = "You rejected a request"; //notification only
                    }else {
                        data.setText(request.getDate().toString() + ", your have a request to approve from:" + request.getRequestingUser().getUsername()+" with average rating "+ MemoryInitializer.getRatingDAO().calculateStats(request.getRequestingUser().getUsername()));
                        colorBackground=Color.parseColor("#22ff00");

                        setApproveOrNotListener(btn,request);
                        not = "Pending.Awaiting for your approval";
                    }

                }
            }
            data.setBackgroundColor(colorBackground);
            btn.setText(not);
            newLayout.addView(btn);
            //Add

            newLayout.addView(data);

            newLayout.setLayoutParams(layoutParams);

            newLayout.setPadding(padding,padding,padding,padding);
            // add the textview to the linearlayout
            sv.addView(newLayout);

        }
        // Display the view
        setContentView(v);
    }

    /**
     * Εμφανίζει ένα Toast.
     * @param m Το περιεχόμενο που θα εμφανιστεί
     */
    public void makeToast(String m){
        Toast.makeText(this,m, Toast.LENGTH_SHORT).show();
    }

    public String getUserName()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }


    public void enterPinListener(Button b,ParkingRequest request) {
        //get switch
            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        public void onClick(View view)
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Notifications.this);
                            builder.setTitle("Pin");
                            builder.setMessage("The requesting user has arrived. Enter the pin he has given you.");
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
                            final EditText input = new EditText(Notifications.this);
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
                                    Log.e("requesting",""+request.toString());
                                    //Do stuff, possibly set wantToCloseDialog to true then...
                                    if(!input.getText().toString().equals("") && presenter.validateParking(request,new Pin(Integer.valueOf(input.getText().toString())))) {
                                        dialog.dismiss();
                                        recreate();
                                    }
                                    //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.
                                }
                            });

                        }
                    });

    }

    public void setApproveOrNotListener(Button b,ParkingRequest request) {
        //get switch
            Log.e("in","in");

            b.setOnClickListener(
                    new View.OnClickListener()
                    {
                        @RequiresApi(api = Build.VERSION_CODES.O)
                        public void onClick(View view)
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(Notifications.this);

                            builder.setTitle("Request for you parking space");
                            builder.setMessage("Your space at "+request.getParkingSpace().getAddress().getStreet()+" wants to be used by "+request.getRequestingUser().getUsername()+" with average rating "+ MemoryInitializer.getRatingDAO().calculateStats(request.getRequestingUser().getUsername()));

                            builder.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // validate parking
                                    presenter.approveRequest(request);
                                    recreate();
                                    Log.e("this is the req",request.getRequestingUser().getUsername());
                                    dialog.dismiss();
                                }
                            });

                            builder.setNegativeButton("DENY", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    // date null
                                    presenter.denyRequest(request);
                                    recreate();
                                    dialog.dismiss();
                                }
                            });

                            AlertDialog alert = builder.create();
                            alert.show();

                        }
                    });

    }
}
