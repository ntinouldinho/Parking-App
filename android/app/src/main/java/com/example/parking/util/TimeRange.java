package com.example.parking.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.TimeZone;

@RequiresApi(api = Build.VERSION_CODES.O)
public class TimeRange {
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeRange(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public TimeRange(LocalDateTime from, long extraMinutesTillExchange) {
        this.from = from;
        this.to = addMinutes(from, extraMinutesTillExchange);
    }

    public TimeRange(long extraMinutesTillExchange) {
        this.from = LocalDateTime.now();
        this.to = addMinutes(from, extraMinutesTillExchange);
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    public long getDifference(){
        return Duration.between(from, to).toMinutes();
    }

    public LocalDateTime addMinutes(LocalDateTime date, long minutes){
        return date.plusMinutes(minutes);
    }


    @Override
    public String toString() {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(from) +
                " -- " +
                dateFormat.format(to);
    }
}
