package com.example.dekutapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dekutapp.components.LecturerDashboardActivity;
import com.example.dekutapp.R;
import com.example.dekutapp.database.LoginDB;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView registerLogin = findViewById(R.id.registerLogin);
        Button register = findViewById(R.id.btnRegister);
        EditText firstName = findViewById(R.id.firstName);
        EditText lastName = findViewById(R.id.lastName);
        EditText regNo = findViewById(R.id.regNo);
        EditText email = findViewById(R.id.emailTxt);
        EditText password = findViewById(R.id.passwordTxt);
        LoginDB loginDB = new LoginDB (this);

        registerLogin.setOnClickListener(view -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        register.setOnClickListener(view -> {
            String firstname = firstName.getText().toString().trim();
            String lastname = lastName.getText().toString().trim();
            String userReg = regNo.getText().toString();
            String userEmail = email.getText().toString().trim();
            String userPassword = password.getText().toString();

            if(firstname.isEmpty() || lastname.isEmpty() || userReg.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty()){
                Snackbar.make(this.getCurrentFocus(),"Please Enter all Fields",Snackbar.LENGTH_LONG).show();
            }else{
                boolean checkUser = loginDB.checkUser(userReg,userEmail);
                if(!checkUser){
                    boolean insert =   loginDB.insertUserData(firstname,lastname,userReg,userEmail,userPassword);
                    if(insert){
                        Intent intent = new Intent(this, LecturerDashboardActivity.class);
                        startActivity(intent);
                        Snackbar.make(this.getCurrentFocus(),"Yaaay!! Registration Successful!",Snackbar.LENGTH_LONG).show();
                    } else {
                        Snackbar.make(this.getCurrentFocus(),"Oops! Registration Failed. Please Try again!",Snackbar.LENGTH_LONG).show();
                    }
                }else {
                    Snackbar.make(this.getCurrentFocus(),"User already exists.",Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }
}