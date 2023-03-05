package com.example.myhouseholdorganaiser.activities;


import static com.example.myhouseholdorganaiser.activities.NewTaskActivity.tasksList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.calendar.MyCalendar;
import com.example.myhouseholdorganaiser.calendar.MyCalendarAdapter;
import com.example.myhouseholdorganaiser.calendar.myCalendarData;
import com.example.myhouseholdorganaiser.databinding.ActivityMainBinding;
import com.example.myhouseholdorganaiser.task.TasksAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    RecyclerView calendar;
    private MyCalendarAdapter calendarAdapter;
    private List<MyCalendar> calendarList = new ArrayList<>();


    private TasksAdapter tasksAdapter;
    //private List<MyTask> tasksList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        binding.userName.setText(intent.getStringExtra("userName"));

        calendar = findViewById(R.id.calendar);
        calendar.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        calendar.setAdapter(new MyCalendarAdapter(calendarList));
        prepareCalendarData();

        binding.newTaskButton.setOnClickListener(this);

        binding.tasks.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

//        binding.tasks.getAdapter().notifyItemChanged(tasksList.size());
        binding.tasks.setAdapter(new TasksAdapter(tasksList));
      //  tasksList.add((MyTask) intent.getSerializableExtra("newTask"));

    }

//    private void initData() {
//        Toast.makeText(this, "Делаю", Toast.LENGTH_SHORT).show();
//        Intent intent = getIntent();
//        tasksList.add((NewTask) intent.getSerializableExtra("newTask"));
//        tasks.getAdapter().notifyItemChanged(tasksList.size());
//    }


    private void prepareCalendarData() {
        RelativeLayout parentRecycle = findViewById(R.id.parent);
        myCalendarData mCalendar = new myCalendarData(-2);
        for (int i = 0; i < 20; i++) {
            MyCalendar calendar = new MyCalendar(String.valueOf(mCalendar.getDay()), mCalendar.getWeekDay(), mCalendar.isToday(), i);
            mCalendar.getNextWeekDay(1);
            calendarList.add(calendar);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_task_button:
                Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.save:
                finish();
                break;
        }
    }
}