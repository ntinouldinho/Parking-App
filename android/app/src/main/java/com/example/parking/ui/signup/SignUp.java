package com.example.parking.ui.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.parking.R;
import com.example.parking.domain.User;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.util.ZipCode;

import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity implements SignUpView{
    private EditText ZipCodeEditText,PhoneEditText,NameEditText,LastEditText,EmailEditText,UsernameEditText,PasswordEditText,StreetNumberEditText,StreetEditText;
    private String zipCode,phone,name,last,email,username,password,street,streetno;
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
                if(validateSignUp()) {
                    presenter.add();
                }
            }
        });

    }

    private boolean validateSignUp() {
        if(validateName()&&validateLast()&&validatePhone()&&validateEmail()&&validateUsername()&&validatePassword()&&validateZipCode()&&validateStreet()&&validateStreetNo()){
            return true;
        }else{
            Toast.makeText(this,"Please recheck your fields!",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean validatePhone(){
        phone = getPhone().trim();
        PhoneEditText = (EditText)findViewById(R.id.phone);
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
        zipCode = getZipCode().trim();
        ZipCodeEditText = (EditText)findViewById(R.id.zip_Code);
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

    private boolean validateName(){
        name = getName().trim();
        NameEditText = (EditText)findViewById(R.id.firstName);
        if(name.isEmpty()){
            NameEditText.setError("Name cannot be empty");
            return false;
        }else{
            NameEditText.setError(null);
            Toast.makeText(this,"Name added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateLast(){
        last = getSurname().trim();
        LastEditText = (EditText)findViewById(R.id.lastName);
        if(last.isEmpty()){
            LastEditText.setError("Last name cannot be empty");
            return false;
        }else{
            LastEditText.setError(null);
            Toast.makeText(this,"Last name added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateEmail(){
        email = getEmail().trim();
        EmailEditText = (EditText)findViewById(R.id.email);
        if(email.isEmpty()){
            EmailEditText.setError("Email cannot be empty");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher((CharSequence)email).matches()){
            EmailEditText.setError("Invalid email");
            return false;
        }else{
            EmailEditText.setError(null);
            Toast.makeText(this,"Email added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateUsername(){
        username = getUsername().trim();
        UsernameEditText = (EditText)findViewById(R.id.Username);
        if(username.isEmpty()){
            UsernameEditText.setError("Username cannot be empty");
            return false;
        }else if(username.length()<=3){
            UsernameEditText.setError("Username must be more than 3 characters");
            return false;
        }else{
            UsernameEditText.setError(null);
            Toast.makeText(this,"Username added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validatePassword() {
        password = getPassword().trim();
        PasswordEditText = (EditText)findViewById(R.id.passwordSignUp);
        Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");
        if(password.isEmpty()){
            PasswordEditText.setError("Password cannot be empty");
            return false;
        }else if(!PASSWORD_PATTERN.matcher(password).matches()){
            PasswordEditText.setError("Password must contain minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character");
            return false;
        }else{
            PasswordEditText.setError(null);
            Toast.makeText(this,"Password added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateStreet() {
        street = getStreet().trim();
        StreetEditText = (EditText)findViewById(R.id.street);
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
        streetno = getStrN().trim();
        StreetNumberEditText = (EditText)findViewById(R.id.number);
        if(streetno.isEmpty()){
            StreetNumberEditText.setError("Street Number cannot be empty");
            return false;
        }else{
            StreetNumberEditText.setError(null);
            Toast.makeText(this,"Street Number added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }






    public String getName(){return ((EditText) findViewById(R.id.firstName)).getText().toString();}
    public String getSurname() {return ((EditText) findViewById(R.id.lastName)).getText().toString();}
    public String getPhone(){return ((EditText) findViewById(R.id.phone)).getText().toString();}
    public String getEmail(){return ((EditText) findViewById(R.id.email)).getText().toString(); }
    public String getUsername(){return ((EditText) findViewById(R.id.Username)).getText().toString(); }
    public String getPassword(){return ((EditText) findViewById(R.id.passwordSignUp)).getText().toString(); }
    public String getStrN(){return ((EditText) findViewById(R.id.number)).getText().toString(); }
    public String getZipCode(){return ((EditText) findViewById(R.id.zip_Code)).getText().toString(); }
    public String getStreet(){return ((EditText) findViewById(R.id.street)).getText().toString(); }

    public void successfullyFinishActivity(String message)
    {
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(RESULT_OK, retData);
        finish();

    }
}
