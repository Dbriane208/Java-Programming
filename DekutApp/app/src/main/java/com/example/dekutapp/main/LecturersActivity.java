package com.example.dekutapp.main;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.dekutapp.Lecturer.LecturerDashboardActivity;
import com.example.dekutapp.R;
import com.example.dekutapp.Student.StudentDashboardActivity;
import com.example.dekutapp.database.LecturersDB;
import com.google.android.material.snackbar.Snackbar;

public class LecturersActivity extends AppCompatActivity {
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturers2);

           Button send = findViewById(R.id.buttonSend);
           EditText firstName = findViewById(R.id.lecturersName);
           EditText time = findViewById(R.id.availableTime);
           EditText email = findViewById(R.id.email);
           EditText department = findViewById(R.id.department);
           LecturersDB loginDB = new LecturersDB(this);

        send.setOnClickListener(view -> {
            String firstname = firstName.getText().toString().trim();
            String Time = time.getText().toString().trim();
            String userEmail = email.getText().toString().trim();
            String Department = department.getText().toString();

            if (firstname.isEmpty() || Time.isEmpty() || userEmail.isEmpty() || Department.isEmpty()) {
                Snackbar.make(LecturersActivity.this.getCurrentFocus(), "Please Enter all Fields", Snackbar.LENGTH_LONG).show();
            } else {
                boolean insert = loginDB.insertLecturersData(firstname, Time, Department,userEmail);
                if (insert) {
                    Intent intent = new Intent(this, StudentDashboardActivity.class);
                    startActivity(intent);
                    Snackbar.make(LecturersActivity.this.getCurrentFocus(), "Yaaay!! Registration Successful!", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(LecturersActivity.this.getCurrentFocus(), "Oops! Registration Failed. Please Try again!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}