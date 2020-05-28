package com.example.parking.ui.Helper;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;

import com.example.parking.util.TimeRange;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DurationSpecifier implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener
{
    public enum pressedButtonType{
        NONE,
        SET_FROM,
        SET_TO
    }

    private int year, month, day;
    private pressedButtonType previouslyPressedBtnType = pressedButtonType.NONE;
    private TimeRange timeRange;

    private final Context context;
    private final TextView[] textViews;

    public DurationSpecifier(Button[] buttons, TextView[] textViews, Context context){
        this.textViews = textViews;
        this.context = context;

        addListenerToDateTimeBtn(buttons[0], pressedButtonType.SET_FROM);
        addListenerToDateTimeBtn(buttons[1], pressedButtonType.SET_TO);
    }

    private void addListenerToDateTimeBtn(Button btn, pressedButtonType type)
    {
        btn.setOnClickListener((v) -> {
            previouslyPressedBtnType = type;
            Calendar c = Calendar.getInstance();
            DatePickerDialog dpD = new DatePickerDialog(context, DurationSpecifier.this,
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH) + 1, //strange bug: it takes the last month as current
                    c.get(Calendar.DAY_OF_MONTH));
            dpD.show();
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void updateTimeRange(LocalDateTime from, LocalDateTime to) {
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

    public TimeRange getTimeRange()
    {
        return this.timeRange;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int y, int m, int d)
    {
        year = y;
        month = m;
        day = d;

        Calendar c = Calendar.getInstance();
        TimePickerDialog tpD = new TimePickerDialog(context, DurationSpecifier.this,
                c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), DateFormat.is24HourFormat(context));
        tpD.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onTimeSet(TimePicker timePicker, int h, int m)
    {
        TextView tv;
        LocalDateTime ld = LocalDateTime.of(year,month,day,h,m);
        if(previouslyPressedBtnType == pressedButtonType.SET_FROM){
            tv = textViews[0];
            updateTimeRange(ld, null);
        }else if(previouslyPressedBtnType == pressedButtonType.SET_TO){
            tv = textViews[1];
            updateTimeRange(null, ld);
        }else{
            return;
        }

        String formattedDate = day+"/"+month+"/"+year;

        String formattedTime = h+":";
        String strM = String.valueOf(m);
        formattedTime += (strM.length() == 1) ? "0"+strM : strM;

        String formattedDateTime = formattedDate+"  -  "+formattedTime;
        tv.setText(formattedDateTime);
    }
}
