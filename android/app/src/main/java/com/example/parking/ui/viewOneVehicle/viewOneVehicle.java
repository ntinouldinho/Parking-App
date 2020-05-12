package com.example.parking.ui.viewOneVehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class viewOneVehicle extends AppCompatActivity implements viewOneVehicleView{
    private EditText PlateEditText,ModelEditText,BrandEditText,LengthText,TextText;
    private String plate,model,brand;
    Button addVehicleBtn;
    viewOneVehiclePresenter presenter;
    private static final String[] paths = {"Red", "Blue", "Green"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);
        presenter = new viewOneVehiclePresenter(this, MemoryInitializer.getUserDAO());





//        PlateEditText = (EditText) findViewById(R.id.plate);
//        ModelEditText = (EditText) findViewById(R.id.model);
//        BrandEditText = (EditText) findViewById(R.id.brand);
//        LengthText = (EditText) findViewById(R.id.length);
//        TextText = (EditText) findViewById(R.id.text);


        addVehicleBtn = (Button) findViewById(R.id.addVehicleBtn);
        addVehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.decide();
            }
        });

    }

    private boolean validatePlate() {
        plate = PlateEditText.getText().toString().trim();
        if (plate.isEmpty()) {
            PlateEditText.setError("Plate cannot be empty");
            return false;
        }

        String letters = plate.substring(0, 3).toUpperCase();
        boolean one = true;
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            if (letter < 65 || letter > 90) {
                one = false;
            }
        }

        String numbers = plate.substring(3);
        boolean two = true;
        for (int i = 0; i < numbers.length(); i++) {
            int number = Integer.valueOf(numbers.charAt(i));
            if (number < 48 || number > 57) {
                two = false;
            }
        }

        if((letters.length() + numbers.length() != 7)||two==false||one==false){
            PlateEditText.setError("Plate must begin with 3 letters and then 4 letters");
            return false;
        }else{
            PlateEditText.setError(null);
            Toast.makeText(this,"Plate added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateModel() {
        model = ModelEditText.getText().toString().trim();
        if (model.isEmpty()) {
            ModelEditText.setError("Model cannot be empty");
            return false;
        }else{
            ModelEditText.setError(null);
            Toast.makeText(this,"Model added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateBrand() {
        brand = BrandEditText.getText().toString().trim();
        if (brand.isEmpty()) {
            BrandEditText.setError("Brand cannot be empty");
            return false;
        }else{
            BrandEditText.setError(null);
            Toast.makeText(this,"Brand added",Toast.LENGTH_SHORT).show();
            return true;
        }
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



    public void setLengthText(int value)
    {
        ((EditText)findViewById(R.id.length)).setText(String.valueOf(value));
    }
    public String getLength()
    {
        return ((EditText) findViewById(R.id.length)).getText().toString();
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

    public void setSpinner(){
        Spinner spinner = (Spinner) findViewById(R.id.Color);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Red added",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(),"Blue added",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(),"Green added",Toast.LENGTH_SHORT).show();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void successfullyFinishActivity(String message)
    {
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(RESULT_OK, retData);
        finish();

    }
}

