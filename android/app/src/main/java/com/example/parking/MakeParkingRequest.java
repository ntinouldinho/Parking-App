package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MakeParkingRequest extends AppCompatActivity {
    private EditText PlateEditText;
    private String plate;
    Button signUpB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_parking_request);

        PlateEditText = (EditText) findViewById(R.id.plate);
        signUpB = (Button) findViewById(R.id.signUp);
        signUpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatePlate();
            }
        });

    }

    private boolean validatePlate(){
        plate = PlateEditText.getText().toString().trim();
        String letters = plate.substring(0,3).toUpperCase();
        boolean one = true;
        for(int i=0;i<letters.length();i++){
            char letter = letters.charAt(i);
            if(letter<65 || letter>90) {
                one = false;
            }
        }

        String numbers = plate.substring(3);
        boolean two = true;
        for(int i=0;i<numbers.length();i++){
            int number = Integer.valueOf(numbers.charAt(i));
            if(number<48 || number>57) {
                two = false;
            }
        }
        if(letters.length()+numbers.length()!=7);

        if(plate.isEmpty()){
            PlateEditText.setError("Plate cannot be empty");
            return false;
        }else if(plate.length()!=7){
            PlateEditText.setError("Plate must start with 3 letters and then with 4 numbers");
            return false;
        }else{
            PlateEditText.setError(null);
            Toast.makeText(this,"Plate added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
