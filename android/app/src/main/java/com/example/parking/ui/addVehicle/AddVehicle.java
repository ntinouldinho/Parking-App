package com.example.parking.ui.addVehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.parking.R;

public class AddVehicle extends AppCompatActivity {
    private EditText PlateEditText,ModelEditText,BrandEditText,LengthText,TextText;
    private String plate,model,brand;
    Button addVehicleBtn;

    private static final String[] paths = {"Red", "Blue", "Green"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle);

        Spinner spinner = (Spinner) findViewById(R.id.Color);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddVehicle.this,
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




        PlateEditText = (EditText) findViewById(R.id.plate);
        ModelEditText = (EditText) findViewById(R.id.model);
        BrandEditText = (EditText) findViewById(R.id.brand);
        LengthText = (EditText) findViewById(R.id.length);
        TextText = (EditText) findViewById(R.id.text);

        String value = getIntent().getExtras().getString("mode");
        if(value.equals("edit")){
            PlateEditText.setText(getIntent().getExtras().getString("plate"));
            ModelEditText.setText(getIntent().getExtras().getString("model"));
            BrandEditText.setText(getIntent().getExtras().getString("model"));
            LengthText.setText(getIntent().getExtras().getString("length"));
            TextText.setText(getIntent().getExtras().getString("text"));
        }
            Toast.makeText(getApplicationContext(),value,Toast.LENGTH_LONG).show();
        addVehicleBtn = (Button) findViewById(R.id.addVehicleBtn);
        addVehicleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatePlate();
                validateModel();
                validateBrand();
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

}
