package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText ZipCodeEditText,PhoneEditText;
    private TextView ZipCodeTextView;
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
            return true;
        }
    }
    public void signUp (View v){
        if(!validatePhone()){
            return;
        }
    }

}
