package com.example.myhouseholdorganaiser.calendar;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
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
        private LinearLayout parent;
        private CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            day = itemView.findViewById(R.id.day);
            parent = itemView.findViewById(R.id.parent);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_item, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyCalendar calendar = myCalendar.get(position);
        Calendar calendarTime = Calendar.getInstance();
       // boolean isChecked = false;
        holder.day.setText(calendar.getDay());
        holder.date.setText(calendar.getDate());
        if (calendarTime.get(Calendar.DAY_OF_MONTH) == Integer.parseInt(calendar.getDay())){
            holder.parent.setBackgroundResource(R.drawable.date_item_today_style);
        }
        Log.d("TTT", String.valueOf(holder.parent.getBackground()));
        Log.d("TTT", String.valueOf(R.drawable.date_item_style));
        holder.parent.setOnClickListener(view->{
            Log.d("TTT", "checked");
            Log.d("TTT", String.valueOf(holder.parent.getBackground().equals(R.drawable.date_item_checked_style)));
            if(holder.parent.getBackground().equals(R.drawable.date_item_checked_style)){
                holder.parent.setBackgroundResource(R.drawable.date_item_style);
                Log.d("TTT", "checkedddd");
            }
            else{
                holder.parent.setBackgroundResource(R.drawable.date_item_checked_style);
            }
        });
    }


    @Override
    public int getItemCount() {
        return myCalendar.size();
    }

    public void onViewRecycled(MyViewHolder holder) {
        recycleCount++;
    }
}
