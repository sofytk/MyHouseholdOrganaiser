package com.example.myhouseholdorganaiser.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.databinding.ActivityNewTaskBinding;
import com.example.myhouseholdorganaiser.task.MyTask;
import com.google.android.material.timepicker.TimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NewTaskActivity extends AppCompatActivity{
    ActivityNewTaskBinding binding;
    public static final List<MyTask> tasksList = new ArrayList<>();
    private MyTask task;
    Calendar calendar = Calendar.getInstance();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        binding = ActivityNewTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                binding.currentTime.setText(new SimpleDateFormat("H:mm").format(calendar.getTime()) );

            }
        };

        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                binding.currentDate.setText(new SimpleDateFormat("d EEEE").format(calendar.getTime()));
            }
        };

        binding.currentDate.setOnClickListener(view->{
            new DatePickerDialog(NewTaskActivity.this, R.style.TimeDatePickerTheme, dateSetListener,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH))
                    .show();
        });

        binding.currentTime.setOnClickListener(view->{
           TimePickerDialog timePickerDialog = new TimePickerDialog(NewTaskActivity.this, R.style.TimeDatePickerTheme,
                    timeSetListener,
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE), true);
           timePickerDialog.show();

        });

        binding.save.setOnClickListener(view->{
            task = new MyTask(binding.newTaskName.getText().toString(), ("Выполнить до " + binding.currentTime.getText()).toString());
            tasksList.add(task);
            Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
            intent.putExtra("newTask", task);
            startActivity(intent);
        });

    }
}