package com.example.myhouseholdorganaiser.calendar;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhouseholdorganaiser.R;

import java.util.Calendar;
import java.util.List;

public class MyCalendarAdapter extends RecyclerView.Adapter<MyCalendarAdapter.MyViewHolder> {

    private final List<MyCalendar> myCalendar;
    private int recycleCount = 0;

    public MyCalendarAdapter(List<MyCalendar> myCalendar) {
        this.myCalendar = myCalendar;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView day;
        private TextView date;
        private RelativeLayout parentRecycle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            day = itemView.findViewById(R.id.day);
            parentRecycle = itemView.findViewById(R.id.parent);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyCalendarAdapter.MyViewHolder holder, int position) {
        MyCalendar calendar = myCalendar.get(position);
        Calendar calendar1 = Calendar.getInstance();
        holder.day.setText(calendar.getDay());
        holder.date.setText(calendar.getDate());
    }

    @Override
    public int getItemCount() {
        return myCalendar.size();
    }

    public void onViewRecycled(MyViewHolder holder) {
        recycleCount++;
    }
}
