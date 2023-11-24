package com.example.dekutapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dekutapp.R;
import com.example.dekutapp.databinding.StudentsLayoutBinding;
import com.example.dekutapp.main.DownloadActivity;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentAdapterViewHolder> {
 private ArrayList Name, Course, Department, Email, Image;
 private Context context;
    @NonNull
    @Override
    public StudentAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentAdapterViewHolder(
                StudentsLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false)
        );
    }

    public StudentsAdapter(Context context,ArrayList Name, ArrayList Course,ArrayList Department, ArrayList Email, ArrayList Image){
       this.context = context;
       this.Name = Name;
        this.Course = Course;
        this.Department = Department;
        this.Email = Email;
        this.Image = Image;
    }

    @Override
    public void onBindViewHolder(StudentAdapterViewHolder holder, int position) {
        byte[] imageData = (byte[]) Image.get(position);

        if (imageData != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
            holder.studentsLayoutBinding.document.setImageBitmap(bitmap);
        } else {
            holder.studentsLayoutBinding.document.setImageResource(R.drawable.user);
        }

        holder.studentsLayoutBinding.name.setText(String.valueOf(Name.get(position)));
        holder.studentsLayoutBinding.course.setText(String.valueOf(Course.get(position)));
        holder.studentsLayoutBinding.department.setText(String.valueOf(Department.get(position)));
        holder.studentsLayoutBinding.email.setText(String.valueOf(Email.get(position)));

        //setting the onclickListener
        holder.studentsLayoutBinding.document.setOnClickListener(view -> {
            Intent intent = new Intent(context, DownloadActivity.class);
            intent.putExtra("imageData",imageData);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }

    public class StudentAdapterViewHolder extends RecyclerView.ViewHolder {
        private final StudentsLayoutBinding studentsLayoutBinding;
        public StudentAdapterViewHolder(StudentsLayoutBinding studentsLayoutBinding) {
            super(studentsLayoutBinding.getRoot());
            this.studentsLayoutBinding = studentsLayoutBinding;
        }
    }
}
