package com.example.myhouseholdorganaiser.mainFragments;

import static android.content.Intent.getIntent;
import static com.example.myhouseholdorganaiser.activities.NewTaskActivity.tasksList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.activities.MainActivity;
import com.example.myhouseholdorganaiser.activities.NewTaskActivity;
import com.example.myhouseholdorganaiser.calendar.MyCalendar;
import com.example.myhouseholdorganaiser.calendar.MyCalendarAdapter;
import com.example.myhouseholdorganaiser.calendar.myCalendarData;
import com.example.myhouseholdorganaiser.databinding.FragmentChooseRoleBinding;
import com.example.myhouseholdorganaiser.databinding.FragmentHomeBinding;
import com.example.myhouseholdorganaiser.task.TasksAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    public static final String tag = "SSS";

    //RecyclerView calendar;
    private MyCalendarAdapter calendarAdapter;
    private List<MyCalendar> calendarList = new ArrayList<>();


    private TasksAdapter tasksAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        Context context = getActivity();

        binding.calendar.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        binding.calendar.setAdapter(new MyCalendarAdapter(calendarList));
        prepareCalendarData();
        binding.calendar.getAdapter().notifyDataSetChanged();

        binding.newTaskButton.setOnClickListener(view->{
            Intent intent1 = new Intent(context, NewTaskActivity.class);
            startActivity(intent1);
        });

        binding.tasks.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

        // binding.calendar.getAdapter().notifyItemChanged(calendarList.size());
        binding.tasks.setAdapter(new TasksAdapter(tasksList));
        //  tasksList.add((MyTask) intent.getSerializableExtra("newTask"));

        return binding.getRoot();
    }
    private void prepareCalendarData() {
        myCalendarData mCalendar = new myCalendarData(-2);
        for (int i = 0; i < 10; i++) {
            MyCalendar calendar = new MyCalendar(String.valueOf(mCalendar.getDay()), mCalendar.getWeekDay(), i);
            mCalendar.getNextWeekDay(1);
            calendarList.add(calendar);
        }
    }
}