package com.example.parking.ui.viewOneVehicle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.parking.R;
import com.example.parking.domain.Vehicle;
import com.example.parking.util.Colour;
import com.example.parking.memorydao.MemoryInitializer;

import java.util.Arrays;

public class viewOneVehicle extends AppCompatActivity implements viewOneVehicleView{
    private EditText PlateEditText,ModelEditText,BrandEditText,LengthText,TextText;
    private String plate,model,brand,finishMessage,ErrorMessage,ErrorTitle,colour;
    Button addVehicleBtn;
    viewOneVehiclePresenter presenter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        presenter = new viewOneVehiclePresenter(this, MemoryInitializer.getUserDAO());

        addVehicleBtn = (Button) findViewById(R.id.addVehicleBtn);
        addVehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.decide();
            }
        });

        String[] names = getNames(Colour.class);
        Spinner spinner = (Spinner) findViewById(R.id.Color);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,names);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        //Toast.makeText(getApplicationContext(),"Red added",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        // Toast.makeText(getApplicationContext(),"Blue added",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        //Toast.makeText(getApplicationContext(),"Green added",Toast.LENGTH_SHORT).show();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }



    public void setBrand(String value)
    {
        ((EditText)findViewById(R.id.brand)).setText(value);
    }
    public String getBrand()
    {
        return ((EditText) findViewById(R.id.brand)).getText().toString();
    }


    public void setModel(String value)
    {
        ((EditText)findViewById(R.id.model)).setText(value);
    }
    public String getModel()
    {
        return ((EditText) findViewById(R.id.model)).getText().toString();
    }



    public void setPlate(String value)
    {
        ((EditText)findViewById(R.id.plate)).setText(value);
    }
    public String getPlateText()
    {
        return ((EditText) findViewById(R.id.plate)).getText().toString();
    }

    @Override
    public void setLength(int value) {
        ((EditText)findViewById(R.id.length)).setText(String.valueOf(value));
    }


    public void setLengthText(int value)
    {
        ((EditText)findViewById(R.id.length)).setText(String.valueOf(value));
    }
    public int getLength()
    {
        String s = ((EditText) findViewById(R.id.length)).getText().toString();
        return Integer.parseInt(s);
    }


    public void setText(String value)
    {
        ((EditText)findViewById(R.id.text)).setText(value);
    }
    public String getText()
    {
        return ((EditText) findViewById(R.id.text)).getText().toString();
    }


    public String getUserName()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }

    public String getPlate()
    {
        return this.getIntent().hasExtra("plate") ? this.getIntent().getExtras().getString("plate") : null;
    }

    public void showErrorMessage(String title, String message)
    {
        new AlertDialog.Builder(viewOneVehicle.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.OK, null).create().show();
    }

    public String getFinishMessage()
    {
        return finishMessage;
    }

    @Override
    public String getErrorMessage() {
        return ErrorMessage;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setSpinner(){

    }

    @Override
    public Colour getColour() {
        return Colour.Black;
    }

    public void successfullyFinishActivity(String message)
    {
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(RESULT_OK, retData);
        finish();

    }

    @Override
    public String getErrorTitle() {
        return ErrorTitle;
    }
}

