package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parking.domain.User;

public class SignUp extends AppCompatActivity {
    private EditText ZipCodeEditText,PhoneEditText;
    private String zipCode,phone;
    Button signUpB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ZipCodeEditText = (EditText) findViewById(R.id.zipCode);
        PhoneEditText = (EditText) findViewById(R.id.phone);

        signUpB = (Button) findViewById(R.id.signUp);
        signUpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatePhone();
                validateZipCode();
            }
        });

    }

    private boolean validatePhone(){
        phone = PhoneEditText.getText().toString().trim();
        if(phone.isEmpty()){
            PhoneEditText.setError("Phone cannot be empty");
            return false;
        }else if(phone.length()!=10){
            PhoneEditText.setError("Phone must be 10 digits");
            return false;
        }else{
            PhoneEditText.setError(null);
            Toast.makeText(this,"Phone added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateZipCode(){
        zipCode = ZipCodeEditText.getText().toString().trim();
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

    public void signUp (View v){
        if(!validatePhone()||!validateZipCode()){
            return;
        }
    }

}
