package com.example.dekutapp.Lecturer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dekutapp.R;
import com.example.dekutapp.adapters.LecturersAdapter;
import com.example.dekutapp.database.LecturersDB;
import com.example.dekutapp.database.StudentsDB;
import com.example.dekutapp.databinding.ActivityLecturerDashboardBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

public class LecturerDashboardActivity extends AppCompatActivity {

    ActivityLecturerDashboardBinding activityLecturerDashboardBinding;
    RecyclerView recyclerView;
    StudentsDB studentDB;
    LecturersAdapter lecturersAdapter;
    ArrayList<String>  Name, Time, Department,Email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLecturerDashboardBinding = ActivityLecturerDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityLecturerDashboardBinding.getRoot());

        studentDB = new StudentsDB(this);
        Name = new ArrayList<>();
        Time = new ArrayList<>();
        Department = new ArrayList<>();
        Email = new ArrayList<>();

        recyclerView = activityLecturerDashboardBinding.studentsRV;
        lecturersAdapter = new LecturersAdapter(this,Name,Time,Department,Email);
        recyclerView.setAdapter(lecturersAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         displayStudentData();
    }

    private void displayStudentData() {
        Cursor cursor = studentDB.getAllStudents();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No available students",Toast.LENGTH_SHORT).show();
        }else{

            Name.clear();
            Time.clear();
            Department.clear();
            Email.clear();

            while(cursor.moveToNext()){
                Name.add(cursor.getString(0));
                Time.add(cursor.getString(1));
                Department.add(cursor.getString(2));
                Email.add(cursor.getString(3));
            }

            lecturersAdapter.notifyDataSetChanged();
        }
    }


}