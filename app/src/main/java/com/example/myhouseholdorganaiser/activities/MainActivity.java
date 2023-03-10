package com.example.myhouseholdorganaiser.activities;


import static com.example.myhouseholdorganaiser.activities.NewTaskActivity.tasksList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.calendar.MyCalendar;
import com.example.myhouseholdorganaiser.calendar.MyCalendarAdapter;
import com.example.myhouseholdorganaiser.calendar.myCalendarData;
import com.example.myhouseholdorganaiser.databinding.ActivityMainBinding;
import com.example.myhouseholdorganaiser.mainFragments.HomeFragment;
import com.example.myhouseholdorganaiser.mainFragments.NotificationFragment;
import com.example.myhouseholdorganaiser.mainFragments.ProfileFragment;
import com.example.myhouseholdorganaiser.mainFragments.RatingFragment;
import com.example.myhouseholdorganaiser.registrationFragments.WelcomeFragment;
import com.example.myhouseholdorganaiser.task.MyTask;
import com.example.myhouseholdorganaiser.task.TasksAdapter;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.myToolbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.notification:
                        swapFragment(new NotificationFragment());
                        return true;
                    case R.id.home:
                        swapFragment(new HomeFragment());
                        return true;
                    case R.id.rating:
                        swapFragment(new RatingFragment());
                        return true;
                    case R.id.profile:
                        swapFragment(new ProfileFragment());
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainPlaceHolder, fragment);
        transaction.commit();
    }
}