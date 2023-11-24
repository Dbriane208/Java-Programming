package com.example.dekutapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dekutapp.Lecturer.LecturerDashboardActivity;
import com.example.dekutapp.R;
import com.example.dekutapp.Student.StudentDashboardActivity;
import com.example.dekutapp.database.LoginDB;
import com.example.dekutapp.main.LecturersActivity;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView loginToRegister = findViewById(R.id.loginToRegister);
        EditText userEmail = findViewById(R.id.textEmail);
        EditText userPassword = findViewById(R.id.textPassword);
        Button buttonLogin = findViewById(R.id.btnLogin);
        LoginDB loginDB = new LoginDB(this);

        buttonLogin.setOnClickListener(view12 -> {
            String email = userEmail.getText().toString();
            String password = userPassword.getText().toString();

            if(email.isEmpty() || password.isEmpty()){
                Snackbar.make(this.getCurrentFocus(),"Please Enter all Fields!",Snackbar.LENGTH_LONG).show();
            }else{
                if(email.matches("lec@dkut.com") && password.matches("lec@dkut")){
                    Snackbar.make(this.getCurrentFocus(),"Logging as Admin successful!",Snackbar.LENGTH_LONG).show();
                    Intent intent = new Intent(this, StudentDashboardActivity.class);
                    startActivity(intent);
                }else{
                    boolean checkUser = loginDB.checkUserEmailAndPassword(email,password);
                    if(checkUser == true){
                        Snackbar.make(this.getCurrentFocus(),"Login Successful!",Snackbar.LENGTH_LONG).show();
                        Intent intent = new Intent(this, LecturerDashboardActivity.class);
                        startActivity(intent);
                    }else{
                        Snackbar.make(this.getCurrentFocus(),"Invalid Credentials",Snackbar.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}