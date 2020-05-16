package com.example.parking.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.TimeZone;


@RequiresApi(api = Build.VERSION_CODES.O)
public class TimeRange {
    private LocalDateTime from;
    private LocalDateTime to;

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/uuuu HH:mm");
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

    public static long getDifference(LocalDateTime ld1, LocalDateTime ld2){
        return Duration.between(ld1, ld2).toMinutes();
    }

    public boolean containsRange(final TimeRange other)
    {
        return getDifference(this.from, other.from) >= 0 &&
                getDifference(other.to, this.to) >= 0;
    }

    public LocalDateTime addMinutes(LocalDateTime date, long minutes){
        return date.plusMinutes(minutes);
    }


    @Override
    public String toString() {
        String fromstr = from.format(formatter);
        String tostr = to.format(formatter);
        return "TimeRange{" +
                "from=" + fromstr +
                ", to=" + tostr +
                '}';
    }
}
