package com.example.myhouseholdorganaiser.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.databinding.ActivityNewTaskBinding;
import com.example.myhouseholdorganaiser.task.MyTask;
import com.noowenz.customdatetimepicker.CustomDateTimePicker;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NewTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    ActivityNewTaskBinding binding;
    public static final List<MyTask> tasksList = new ArrayList<>();
    private MyTask task;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        binding = ActivityNewTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.save.setOnClickListener(view->{
            task = new MyTask(binding.newTaskName.getText().toString(), binding.dateOfTask.getText().toString());
            tasksList.add(task);
            Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
            intent.putExtra("newTask", task);
            startActivity(intent);
        });
        binding.currentDate.setOnClickListener(view->{
            com.example.myhouseholdorganaiser.calendar.DatePicker mDatePickerDialogFragment;
            mDatePickerDialogFragment = new com.example.myhouseholdorganaiser.calendar.DatePicker();
            mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, month);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(mCalendar.getTime());
        binding.dateOfTask.setText(selectedDate);
    }

    public String getDate() {
        return binding.dateOfTask.toString();
    }

}