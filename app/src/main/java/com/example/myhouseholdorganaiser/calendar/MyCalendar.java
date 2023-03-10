package com.example.myhouseholdorganaiser.calendar;

public class MyCalendar {

    private String day;
    private String date;
    private int pos;

    public MyCalendar(String day, String date, int i) {
        this.day = day;
        this.date = date;
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
}
