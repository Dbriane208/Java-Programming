package com.example.dekutapp.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dekutapp.adapters.StudentsAdapter;
import com.example.dekutapp.database.LecturersDB;
import com.example.dekutapp.databinding.ActivityStudentDashboardBinding;
import com.example.dekutapp.main.StudentActivity;

import java.util.ArrayList;

public class StudentDashboardActivity extends AppCompatActivity {
    ActivityStudentDashboardBinding studentDashboardBinding;

    RecyclerView recyclerView;
    LecturersDB lecturersDB;
    StudentsAdapter studentsAdapter;
    ArrayList<String> Name, Course, Department, Email;
    ArrayList<byte[]> Image;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        studentDashboardBinding = ActivityStudentDashboardBinding.inflate(getLayoutInflater());
        setContentView(studentDashboardBinding.getRoot());


        studentDashboardBinding.postWork.setOnClickListener(view -> {
            Intent intent = new Intent(this, StudentActivity.class);
            startActivity(intent);
        });


        lecturersDB = new LecturersDB(this);
        Name = new ArrayList<>();
        Course = new ArrayList<>();
        Department = new ArrayList<>();
        Email = new ArrayList<>();
        Image = new ArrayList<byte[]>();

        recyclerView = studentDashboardBinding.lecturersRV;
        studentsAdapter = new StudentsAdapter(this,Name,Course,Department,Email,Image);
        recyclerView.setAdapter(studentsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayAllLecturers();

    }

    private void displayAllLecturers() {
        Cursor cursor = lecturersDB.getAvailableLecturers();
        if(cursor.getCount() == 0){
            Toast.makeText(this,"No lecturers Available",Toast.LENGTH_SHORT).show();
        }else{
            Name.clear();
            Course.clear();
            Department.clear();
            Email.clear();
            Image.clear();

            while(cursor.moveToNext()){
                Name.add(cursor.getString(0));
                Course.add(cursor.getString(1));
                Department.add(cursor.getString(2));
                Email.add(cursor.getString(3));
                Image.add(cursor.getBlob(4));
            }

            studentsAdapter.notifyDataSetChanged();
        }
    }

}