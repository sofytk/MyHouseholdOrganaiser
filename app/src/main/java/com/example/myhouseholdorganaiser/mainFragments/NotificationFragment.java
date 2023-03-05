package com.example.myhouseholdorganaiser.mainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myhouseholdorganaiser.databinding.FragmentChooseRoleBinding;
import com.example.myhouseholdorganaiser.databinding.FragmentNotifyBinding;

public class NotificationFragment extends Fragment {
    private FragmentNotifyBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentNotifyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
