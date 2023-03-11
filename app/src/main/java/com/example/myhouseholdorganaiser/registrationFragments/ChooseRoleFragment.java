package com.example.myhouseholdorganaiser.registrationFragments;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.databinding.FragmentChooseRoleBinding;

public class ChooseRoleFragment extends Fragment {
    private FragmentChooseRoleBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentChooseRoleBinding.inflate(inflater, container, false);
        binding.roleDad.setOnClickListener(view->{
            swapFragment(new EnterFamilyCodeFragment());
        });

        binding.roleMum.setOnClickListener(view->{
            swapFragment(new EnterFamilyCodeFragment());
        });

        binding.roleDauther.setOnClickListener(view->{
            swapFragment(new EnterFamilyCodeFragment());
        });

        binding.roleSon.setOnClickListener(view->{
            swapFragment(new EnterFamilyCodeFragment());
        });

        return binding.getRoot();

    }
    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.placeHolder, fragment);
        transaction.commit();
    }
}