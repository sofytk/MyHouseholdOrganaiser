package com.example.myhouseholdorganaiser.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class myCalendarData {

    private final Calendar calendar;

    private int startDay;
    private int dayOfWeek;
    private String stringDayOfWeek;
    private String toDay;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("EEE");

    public  myCalendarData (int start){
        this.calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, start);
        setThis();
    }


    private void setThis (){
        this.startDay = calendar.get(Calendar.DAY_OF_MONTH);
        this.dayOfWeek= calendar.get(Calendar.DAY_OF_WEEK);
        this.stringDayOfWeek = dateFormat.format(calendar.getTime());

    }

    public void getNextWeekDay(int nxt){
        calendar.add(Calendar.DATE, nxt);
        setThis();
    }

    public String getWeekDay (){
        return this.stringDayOfWeek;
    }

    public int getDay(){
        return this.startDay;
    }


}
