package com.example.myhouseholdorganaiser.registrationFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.activities.MainActivity;
import com.example.myhouseholdorganaiser.databinding.FragmentCreateNewFamilyCodeBinding;
import com.example.myhouseholdorganaiser.databinding.FragmentEnterFamilyCodeBinding;

public class CreateNewFamilyCodeFragment extends Fragment {

    private FragmentCreateNewFamilyCodeBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCreateNewFamilyCodeBinding.inflate(inflater, container, false);

        binding.newFamilyCode.setOnClickListener(view->{
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
        return binding.getRoot();
    }
    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.placeHolder, fragment);
        transaction.commit();
    }
}