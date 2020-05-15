package com.example.parking.ui.newParking;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.parking.R;
import com.example.parking.memorydao.MemoryInitializer;
import com.example.parking.ui.homescreen.HomeScreenActivity;
import com.example.parking.util.TimeRange;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class NewParkingSpace extends AppCompatActivity implements NewParkingView,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private enum pressedButtonType{
        NONE,
        SET_FROM,
        SET_TO
    }

    private NewParkingPresenter presenter;
    private int yearFinal,monthFinal,dayFinal;
    private Button setFrom, setTo;
    private TextView dateTimeInfoFrom, getDateTimeInfoTo;
    private pressedButtonType previouslyPressed = pressedButtonType.NONE;
    private TimeRange timeRange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_parking_space);
        presenter = new NewParkingPresenter(this, MemoryInitializer.getUserDAO(),MemoryInitializer.getParkingDAO());

        addListenerToDateTimeBtn(findViewById(R.id.setDateTimeFromNewParking), pressedButtonType.SET_FROM);
        addListenerToDateTimeBtn(findViewById(R.id.setDateTimeToNewParking), pressedButtonType.SET_TO);

        Button btn = (Button) findViewById(R.id.addVehicleBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if( validateAddParking()) {
                    presenter.add();
                }
            }
        });
    }

    private void addListenerToDateTimeBtn(Button btn, pressedButtonType type) {
        btn.setOnClickListener((v) -> {
            previouslyPressed = type;
            Calendar c = Calendar.getInstance();
            DatePickerDialog dpD = new DatePickerDialog(NewParkingSpace.this, NewParkingSpace.this,
                    c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
            dpD.show();
        });
    }

    @Override
    public void onDateSet(DatePicker dp, int y, int m, int d){
        yearFinal = y;
        monthFinal = m;
        dayFinal = d;

        Calendar c = Calendar.getInstance();
        TimePickerDialog tpD = new TimePickerDialog(NewParkingSpace.this, NewParkingSpace.this,
                c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), DateFormat.is24HourFormat(this));
        tpD.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onTimeSet(TimePicker dp, int h, int m){
        TextView tv;
        LocalDateTime ld = LocalDateTime.of(yearFinal,monthFinal,dayFinal,h,m);
        if(previouslyPressed == pressedButtonType.SET_FROM){
            tv = (TextView) findViewById(R.id.dateTimeFromInfoNewParking);
            updateTimeRange(ld, null);
        }else if(previouslyPressed == pressedButtonType.SET_TO){
            tv = (TextView) findViewById(R.id.dateTimeFromToNewParking);
            updateTimeRange(null, ld);
        }else{
            return;
        }

        String formattedDate = dayFinal+"/"+monthFinal+"/"+yearFinal;

        String formattedTime = h+":";
        String strM = String.valueOf(m);
        formattedTime += (strM.length() == 1) ? "0"+strM : strM;

        String formattedDateTime = formattedDate+"  -  "+formattedTime;
        tv.setText(formattedDateTime);
    }

    private boolean validateAddParking() {
        if(validateStreet()&&validateStreetNo()&&validateZipCode()&&validateCredits()){
            return true;
        }else{
            Toast.makeText(this,"Please recheck your fields!",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean validateStreet() {
        String street = getStreet().trim();
        EditText StreetEditText = (EditText)findViewById(R.id.Street);
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
        String streetno = getStreetNumber().trim();
        EditText StreetNumberEditText = (EditText)findViewById(R.id.StreetNumber);
        if(streetno.isEmpty()){
            StreetNumberEditText.setError("Street Number cannot be empty");
            return false;
        }else{
            StreetNumberEditText.setError(null);
            Toast.makeText(this,"Street Number added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    private boolean validateZipCode(){
        String zipCode = getZipCode().trim();
        EditText ZipCodeEditText = (EditText)findViewById(R.id.zipCode);
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

    private boolean validateCredits(){
        String credits = getCredits().trim();
        EditText CreditsEditText = (EditText)findViewById(R.id.creditsForParking);
        if(credits.isEmpty()){
            CreditsEditText.setError("Credits cannot be empty");
            return false;
        }
        int c = Integer.valueOf(credits);
        if(c<=0||c>=16){
            CreditsEditText.setError("Desired credits cannot be zero/negative or exceed 16!");
            return false;
        }else{
            CreditsEditText.setError(null);
            Toast.makeText(this,"Credits added",Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public String getStreet()
    {
        return ((EditText) findViewById(R.id.Street)).getText().toString();
    }

    public String getStreetNumber()
    {
        return ((EditText) findViewById(R.id.StreetNumber)).getText().toString();
    }


    public String getZipCode()
    {
        return ((EditText) findViewById(R.id.zipCode)).getText().toString();
    }

    public String getPlate()
    {
        return ((Spinner) findViewById(R.id.CarChoice)).getSelectedItem().toString();
    }

    public String getCredits()
    {
        return ((EditText) findViewById(R.id.creditsForParking)).getText().toString();
    }

    public TimeRange getTimeRange()
    {
        return this.timeRange;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void updateTimeRange(LocalDateTime from, LocalDateTime to) {
        if(this.timeRange == null){
            this.timeRange = new TimeRange(0);
        }

        if(from != null){
            this.timeRange.setFrom(from);
        }
        if(to != null){
            this.timeRange.setTo(to);
        }
    }

    public void setSpinner(ArrayList<String> plates){
        Spinner spinner = (Spinner) findViewById(R.id.CarChoice);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewParkingSpace.this, android.R.layout.simple_spinner_dropdown_item,plates);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }



    public void successfullyFinishActivity()
    {
        Intent retData = new Intent(NewParkingSpace.this,HomeScreenActivity.class);
        retData.putExtra("message_to_toast", "all good");
        setResult(RESULT_OK, retData);
        finish();

    }


    public String getUsername()
    {
        return this.getIntent().hasExtra("username") ? this.getIntent().getExtras().getString("username") : null;
    }

    public void makeToast(String m){
        Toast.makeText(this,m, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
