package com.example.myhouseholdorganaiser.registrationFragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.databinding.FragmentSignUpBinding;

public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        binding.signIn.setOnClickListener(view ->{
            swapFragment(new SignInFragment());
        });
        binding.signup.setOnClickListener(view->{
            swapFragment(new ChooseRoleFragment());
        });
        return binding.getRoot();
    }
    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.placeHolder, fragment);
        transaction.commit();
    }

}