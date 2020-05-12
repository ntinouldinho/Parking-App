package com.example.parking.ui.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.parking.R;
import com.example.parking.domain.User;
import com.example.parking.memorydao.MemoryInitializer;

public class SignUp extends AppCompatActivity implements SignUpView{
    private EditText ZipCodeEditText,PhoneEditText;
    private String zipCode,phone;
    Button signUpB;
    SignUpPresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        presenter = new SignUpPresenter(this, MemoryInitializer.getUserDAO());

        signUpB = (Button) findViewById(R.id.signUp);
        signUpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.add();
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

    public String getName(){return ((EditText) findViewById(R.id.firstName)).getText().toString();}
    public String getSurname() {return ((EditText) findViewById(R.id.lastName)).getText().toString();}
    public String getPhone(){return ((EditText) findViewById(R.id.phone)).getText().toString();}
    public String getEmail(){return ((EditText) findViewById(R.id.email)).getText().toString(); }
    public String getUsername(){return ((EditText) findViewById(R.id.Username)).getText().toString(); }
    public String getPassword(){return ((EditText) findViewById(R.id.password)).getText().toString(); }
    public String getStrN(){return ((EditText) findViewById(R.id.number)).getText().toString(); }
    public String getZipCode(){return ((EditText) findViewById(R.id.zipCode)).getText().toString(); }
    public String getStreet(){return ((EditText) findViewById(R.id.street)).getText().toString(); }

    public void successfullyFinishActivity(String message)
    {
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(RESULT_OK, retData);
        finish();

    }
}
