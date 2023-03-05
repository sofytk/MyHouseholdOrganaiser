package com.example.myhouseholdorganaiser.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.databinding.ActivityRegistrationBinding;
import com.example.myhouseholdorganaiser.registrationFragments.WelcomeFragment;

public class RegistationActivity extends AppCompatActivity {
    ActivityRegistrationBinding binding;
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        context = getApplicationContext();
        swapFragment(new WelcomeFragment());
    }

    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.placeHolder, fragment);
        transaction.commit();
    }
    public static Context getContext(){
        return context;
    }
}