package com.example.parking.ui.newParking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.parking.R;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.homescreen.HomeScreenActivity;
import com.example.parking.util.Credits;

import java.time.Duration;
import java.util.ArrayList;

public class NewParkingSpace extends AppCompatActivity implements NewParkingView{
    NewParkingPresenter presenter;

    private EditText ZipCodeEditText,StreetNumberEditText,StreetEditText,CreditsEditText;
    private String zipCode,street,streetno,credits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_parking_space);
        presenter = new NewParkingPresenter(this, MemoryInitializer.getUserDAO(),MemoryInitializer.getParkingDAO());

        Button btn = (Button) findViewById(R.id.addVehicleBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if( validateAddParking()) {
                    presenter.add();
                }
            }
        });

    }

    private boolean validateAddParking() {
        if(validateStreet()&&validateStreetNo()&&validateZipCode()&&validateCredits()){
            return true;
        }else{
            Toast.makeText(this,"Please recheck your fields!",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean validateStreet() {
        street = getStreet().trim();
        StreetEditText = (EditText)findViewById(R.id.Street);
        if(street.isEmpty()){
            StreetEditText.setError("Street cannot be empty");
            return false;
        }else{
            StreetEditText.setError(null);
            Toast.makeText(this,"Street added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateStreetNo() {
        streetno = getStreetNumber().trim();
        StreetNumberEditText = (EditText)findViewById(R.id.StreetNumber);
        if(streetno.isEmpty()){
            StreetNumberEditText.setError("Street Number cannot be empty");
            return false;
        }else{
            StreetNumberEditText.setError(null);
            Toast.makeText(this,"Street Number added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateZipCode(){
        zipCode = getZipCode().trim();
        ZipCodeEditText = (EditText)findViewById(R.id.zipCode);
        if(zipCode.isEmpty()){
            ZipCodeEditText.setError("ZIP Code cannot be empty");
            return false;
        }else if(zipCode.length()!=5){
            ZipCodeEditText.setError("ZIP Code must be 5 digits");
            return false;
        }else{
            ZipCodeEditText.setError(null);
            Toast.makeText(this,"ZIP Code added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateCredits(){
        credits = getCredits().trim();
        CreditsEditText = (EditText)findViewById(R.id.creditsForParking);
        if(credits.isEmpty()){
            CreditsEditText.setError("Credits cannot be empty");
            return false;
        }
        int c = Integer.valueOf(credits);
        if(c<=0||c>=16){
            CreditsEditText.setError("Desired credits cannot be zero/negative or exceed 16!");
            return false;
        }else{
            CreditsEditText.setError(null);
            Toast.makeText(this,"Credits added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public String getStreet()
    {
        return ((EditText) findViewById(R.id.Street)).getText().toString();
    }

    public String getStreetNumber()
    {
        return ((EditText) findViewById(R.id.StreetNumber)).getText().toString();
    }


    public String getZipCode()
    {
        return ((EditText) findViewById(R.id.zipCode)).getText().toString();
    }

    public String getPlate()
    {
        return ((Spinner) findViewById(R.id.CarChoice)).getSelectedItem().toString();
    }

    public String getCredits()
    {
        return ((EditText) findViewById(R.id.creditsForParking)).getText().toString();
    }

    public void setSpinner(ArrayList<String> plates){
        Spinner spinner = (Spinner) findViewById(R.id.CarChoice);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewParkingSpace.this, android.R.layout.simple_spinner_dropdown_item,plates);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void successfullyFinishActivity(String message)
    {
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(RESULT_OK, retData);
        finish();

    }


    public String getUsername()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }

    public void makeToast(String m){
        Toast.makeText(this,m, Toast.LENGTH_SHORT).show();
    }

}
