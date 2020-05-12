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

import java.time.Duration;
import java.util.ArrayList;

public class NewParkingSpace extends AppCompatActivity implements NewParkingView{
    NewParkingPresenter presenter;
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
                presenter.add();
            }
        });

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
