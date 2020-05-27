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
                    presenter.add();
            }
        });

    }

    /**
     * Εμφανίζει ένα Toast.
     * @param toaster Το περιεχόμενο που θα εμφανιστεί
     */
    public void makeToast(String toaster){
        Toast.makeText(this,toaster,Toast.LENGTH_SHORT).show();
    }


    /**
     * Εμφανίζει ένα error δίπλα απο συγκεκριμένο πεδίο.
     * @param EditText Το όνομα του κουμπιού στο οποίο θα εμφανιστεί το σφάλμα
     * @param error Το περιεχόμενο του σφάλματος που θα εμφανιστεί
     */
    public void setError(String EditText,String error){
        if(EditText.equals("firstname")){
            ((EditText)findViewById(R.id.firstName)).setError(error);
        }else if(EditText.equals("lastname")){
            ((EditText)findViewById(R.id.lastName)).setError(error);
        }else if(EditText.equals("phone")){
            ((EditText)findViewById(R.id.phone)).setError(error);
        }else if(EditText.equals("email")){
            ((EditText)findViewById(R.id.email)).setError(error);
        }else if(EditText.equals("username")){
            ((EditText)findViewById(R.id.Username)).setError(error);
        }else if(EditText.equals("password")){
            ((EditText)findViewById(R.id.passwordSignUp)).setError(error);
        }else if(EditText.equals("street")){
            ((EditText)findViewById(R.id.street)).setError(error);
        }else if(EditText.equals("streetno")){
            ((EditText)findViewById(R.id.number)).setError(error);
        }else if(EditText.equals("zip")){
            ((EditText)findViewById(R.id.zip_Code)).setError(error);
        }
    }


    /**
     * Το μήνυμα πoυ εμφανίζεται όταν τελειώνει
     * επιτυχώς ένα activity.
     * @param message Το μήνυμα που θα εμφανίσει
     */
    public void successfullyFinishActivity(String message){
        Intent retData = new Intent();
        retData.putExtra("message_to_toast", message);
        setResult(RESULT_OK, retData);
        finish();

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
}
