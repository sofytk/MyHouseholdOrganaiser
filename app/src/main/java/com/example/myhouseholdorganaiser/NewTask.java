package com.example.myhouseholdorganaiser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.myhouseholdorganaiser.databinding.ActivityMainBinding;
import com.example.myhouseholdorganaiser.databinding.ActivityNewTaskBinding;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NewTask extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
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

        MyClickListener listener = new MyClickListener();

        binding.save.setOnClickListener(listener);
        binding.currentDate.setOnClickListener(listener);


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

    class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.currentDate:
                    com.example.myhouseholdorganaiser.DatePicker mDatePickerDialogFragment;
                    mDatePickerDialogFragment = new com.example.myhouseholdorganaiser.DatePicker();
                    mDatePickerDialogFragment.show(getSupportFragmentManager(), "DATE PICK");
                    break;
                case R.id.new_task_button:
                    finish();
                    break;
                case R.id.save:
                    task = new MyTask(binding.newTaskName.getText().toString(), binding.dateOfTask.getText().toString());
                    tasksList.add(task);
                    Intent intent = new Intent(NewTask.this, MainActivity.class);
                    intent.putExtra("newTask", task);
                    startActivity(intent);
                    break;
            }

        }
    }

}