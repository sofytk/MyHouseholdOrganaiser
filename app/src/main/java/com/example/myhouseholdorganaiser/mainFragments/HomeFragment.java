package com.example.myhouseholdorganaiser.mainFragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.activities.MainActivity;
import com.example.myhouseholdorganaiser.calendar.MyCalendar;
import com.example.myhouseholdorganaiser.calendar.MyCalendarAdapter;
import com.example.myhouseholdorganaiser.calendar.myCalendarData;
import com.example.myhouseholdorganaiser.databinding.FragmentChooseRoleBinding;
import com.example.myhouseholdorganaiser.databinding.FragmentHomeBinding;
import com.example.myhouseholdorganaiser.task.TasksAdapter;

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
        return binding.getRoot();
    }
}