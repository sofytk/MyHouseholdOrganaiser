//package com.example.myhouseholdorganaiser;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Patterns;
//import android.view.View;
//import android.widget.Toast;
//
//import com.example.myhouseholdorganaiser.activities.MainActivity;
//import com.example.myhouseholdorganaiser.databinding.ActivityRegistrationBinding;
//
//public class registration extends AppCompatActivity implements View.OnClickListener {
//    ActivityRegistrationBinding binding;
//
//    public String password;
//    public String email;
//    public String name;
//    protected boolean correctPassword = false;
//    protected boolean correctEmail = false;
//    protected boolean correctName = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//       // binding.registration.setOnClickListener(this);
//    }
//
//    private String checkPassword(String password) {
//        if (password.isEmpty()) {
//            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
//            return "";
//        }
//        if (password.length() >= 8) {
//            correctPassword = true;
//            return this.password = password;
//        } else {
//            Toast.makeText(this, "Пароль должен содержать больше 8 символов", Toast.LENGTH_SHORT).show();
//            return "";
//        }
//
//    }
//
//    private String checkEmail(String email) {
//        if (email.isEmpty()) {
//            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
//            return "";
//        }
//        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            correctEmail = true;
//            return this.email = email;
//
//        } else {
//            Toast.makeText(this, "Некорректная почта", Toast.LENGTH_SHORT).show();
//            return "";
//        }
//    }
//
//    private String checkName(String name){
//        if(name.isEmpty()){
//            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
//            return "";
//        }
//        else{
//            correctName = true;
//            return this.name = name;
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        do {
////            checkPassword(binding.password.getText().toString());
////            checkEmail(binding.email.getText().toString());
////            checkName(binding.name.getText().toString());
//        } while (!correctPassword && !correctEmail && !correctName);
//
//        if (correctEmail && correctPassword && correctName) {
//            switch (v.getId()) {
//                case R.id.registration:
//
//                    Intent intent = new Intent(registration.this, MainActivity.class);
//                    intent.putExtra("userName", name);
//                    startActivity(intent);
//                    break;
//            }
//        }
//    }
//}
//
