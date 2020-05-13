package com.example.parking.ui.viewUser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.parking.R;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.viewVehicles.ViewVehicles;

import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity implements UserProfileView
{
    static String m_Text = "";
    UserProfilePresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        presenter = new UserProfilePresenter(this, MemoryInitializer.getUserDAO());


    }


    public void addClickListeners()
    {
        ((Button) findViewById((R.id.saveBtnUserProfile))).setOnClickListener((v) -> {
            presenter.update();
            recreate();
        });

        ((Button) findViewById((R.id.manageCarsBtnUserProfile))).setOnClickListener((v) -> {
            Intent myIntent = new Intent(this, ViewVehicles.class);
            myIntent.putExtra("username", getUsername());
            startActivityForResult(myIntent,1);
        });

        ((Button) findViewById((R.id.addCreditsBtnUserProfile))).setOnClickListener((v) -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            EditText creditsToBeAdded = (EditText) findViewById(R.id.creditsToBeAddedUserProfile);

            builder.setTitle("Confirm");
            builder.setMessage(creditsToBeAdded.getText()+" credits will be added to your account.Are you sure?");

            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    // Do nothing but close the dialog
                    int totalCredits = Integer.parseInt(getCredits()) +
                            Integer.parseInt(creditsToBeAdded.getText().toString());
                    setCredits(totalCredits);
                    presenter.update();

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
        });
    }
    public String getUsername()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }
    @Override
    public void setCredits(int credits){
        ((TextView)findViewById(R.id.creditsNumUserProfile)).setText(String.valueOf(credits));
    }
    @Override
    public String getCredits(){
        return ((TextView) findViewById(R.id.creditsNumUserProfile)).getText().toString();
    }

    @Override
    public String getFirstName(){
        return ((EditText) findViewById(R.id.firstNameUserProfile)).getText().toString();
    }
    @Override
    public void setFirstName(String value){
        ((EditText)findViewById(R.id.firstNameUserProfile)).setText(value);
    }

    @Override
    public String getLastName(){
        return ((EditText) findViewById(R.id.lastNameUserProfile6)).getText().toString();
    }
    @Override
    public void setLastName(String value){
        ((EditText)findViewById(R.id.lastNameUserProfile6)).setText(value);
    }


    @Override
    public String getEmail(){
        return ((EditText) findViewById(R.id.emailUserProfile)).getText().toString();
    }
    @Override
    public void setEmail(String value){
        ((EditText)findViewById(R.id.emailUserProfile)).setText(value);
    }

    @Override
    public String getZip(){
        return ((EditText) findViewById(R.id.zipcodeUserProfile)).getText().toString();
    }
    @Override
    public void setZip(String value){
        ((EditText)findViewById(R.id.zipcodeUserProfile)).setText(value);
    }

    @Override
    public String getStreet(){
        return ((EditText) findViewById(R.id.addressUserProfile)).getText().toString();
    }
    @Override
    public void setStreet(String value){
        ((EditText)findViewById(R.id.addressUserProfile)).setText(value);
    }



    @Override
    public String getStreetNo(){
        return ((EditText) findViewById(R.id.streetNo)).getText().toString();
    }
    @Override
    public void setStreetNo(String value){
        ((EditText)findViewById(R.id.streetNo)).setText(value);
    }


    @Override
    public String getPhone(){
        return ((EditText) findViewById(R.id.phoneUserProfile)).getText().toString();
    }
    @Override
    public void setPhone(String value){
        ((EditText)findViewById(R.id.phoneUserProfile)).setText(value);
    }




}
