package com.example.myhouseholdorganaiser.registrationFragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myhouseholdorganaiser.R;
import com.example.myhouseholdorganaiser.activities.MainActivity;
import com.example.myhouseholdorganaiser.databinding.FragmentSignUpBinding;


public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding binding;
    protected boolean correctPassword = false;
    protected boolean correctEmail = false;
    protected boolean correctName = false;
    private boolean doubleTruePassword = false;
    public String password;
    public String email;
   public String name;


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
            do {
                checkPassword(binding.password.getText());
                checkEmail(binding.email.getText());
                checkName(binding.userName.getText());
                Log.d("SSS", binding.password.getText());
            } while (!correctPassword && !correctEmail && !correctName );
            if (correctEmail && correctPassword && correctName) {
                swapFragment(new ChooseRoleFragment());
            }
        });



        return binding.getRoot();
    }
    private void swapFragment(Fragment fragment) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.placeHolder, fragment);
        transaction.commit();
    }
    private String checkPassword(String password) {
        if (password.isEmpty()) {
            Toast.makeText(getActivity(), "Пустое поле", Toast.LENGTH_SHORT).show();
            return "";
        }
//        if (binding.password.getText() != binding.passwordRepeat.getText()) {
//            doubleTruePassword = false;
//            Toast.makeText(getActivity(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();
//            return "";
//        }
//        else doubleTruePassword = true;
        if (password.length() >= 8) {
            correctPassword = true;
            return this.password = password;
        } else {
            Toast.makeText(getActivity(), "Пароль должен содержать больше 8 символов", Toast.LENGTH_SHORT).show();
            return "";
        }

    }

    private String checkEmail(String email) {
        if (email.isEmpty()) {
            Toast.makeText(getActivity(), "Пустое поле", Toast.LENGTH_SHORT).show();
            return "";
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            correctEmail = true;
            return this.email = email;

        } else {
            Toast.makeText(getActivity(), "Некорректная почта", Toast.LENGTH_SHORT).show();
            return "";
        }
    }

    private String checkName(String name){
        if(name.isEmpty()){
            Toast.makeText(getActivity(), "Пустое поле", Toast.LENGTH_SHORT).show();
            return "";
        }
        else{
            correctName = true;
            return this.name = name;
        }
    }


}