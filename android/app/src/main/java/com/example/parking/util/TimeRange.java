package com.example.parking.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeRange {
    private Date from;
    private Date to;

    public TimeRange(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public TimeRange() {
        this.from = new Date();
        this.to = addTime(from,30);
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public long difference(Instant from, Instant to){
        ZoneId zone = ZoneId.systemDefault();

        ZonedDateTime todayInZone = from.atZone(zone);
        ZonedDateTime expirationInZone = to.atZone(zone);
        long daysTilExp = todayInZone.toLocalDate().until(expirationInZone, ChronoUnit.MINUTES);
        return daysTilExp;
    }
    public String toString() {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        final StringBuilder builder = new StringBuilder();
        builder.append(dateFormat.format(from));
        builder.append(" -- ");
        builder.append(dateFormat.format(to));
        return builder.toString();
    }

    public static Date addTime(Date date, int minutes){
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minutes);
        currentDate = c.getTime();
        return currentDate;
    }

}
