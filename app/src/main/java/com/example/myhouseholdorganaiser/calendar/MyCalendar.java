package com.example.myhouseholdorganaiser.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyCalendar {

    private String day;
    private String date;
    private int pos;
    private boolean isToday;


    public MyCalendar(String day, String date, boolean isToday, int i) {
        this.day = day;
        this.date = date;
        this.isToday = isToday;
        this.pos = i;
    }

    public int getPos() {
        return pos;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String date) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isToday() {
        return isToday;
    }

    public void setToday(boolean today) {
        isToday = today;
    }
}
