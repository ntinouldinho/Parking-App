package com.example.parking.ui.viewUser;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.parking.R;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfile extends AppCompatActivity
{
    private EditText fName, lName, email, zipCode, address, phone;
    private TextView creditsNum;
    private Button saveBtn, manageCarsBtn, addCreditsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        getUIReferences();
        fillEditTextsWithSavedData();
        addClickListeners();
    }

    private void getUIReferences()
    {
        fName = (EditText) findViewById(R.id.firstName);
        lName = (EditText) findViewById(R.id.lastName);
        email = (EditText) findViewById(R.id.emailUserProfile);
        zipCode = (EditText) findViewById(R.id.zipCode);
        address = (EditText) findViewById(R.id.addressUserProfile);
        phone = (EditText) findViewById(R.id.phoneUserProfile);

        creditsNum = (TextView) findViewById(R.id.creditsNumUserProfile);

        saveBtn = (Button) findViewById((R.id.saveBtnUserProfile));
        manageCarsBtn = (Button) findViewById((R.id.manageCarsBtnUserProfile));
        addCreditsBtn = (Button) findViewById((R.id.addCreditsBtnUserProfile));
    }

    private void fillEditTextsWithSavedData()
    {
        //load the data and fill the texts
    }

    private void addClickListeners()
    {
        saveBtn.setOnClickListener((v) -> {
            //get the contents of all the editTexts and save them
        });

        manageCarsBtn.setOnClickListener((v) -> {
            //change activity to manage cars
        });

        addCreditsBtn.setOnClickListener((v) -> {
            // add the specified credits to the total sum
        });
    }

}
