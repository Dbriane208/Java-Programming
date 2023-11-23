package com.example.dekutapp.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dekutapp.databinding.LecturersLayoutBinding;

import java.util.ArrayList;

public class LecturersAdapter extends RecyclerView.Adapter<LecturersAdapter.LecturersAdapterViewHolder> {
    private ArrayList Name,Time,Department,Email;
    private Context context;

    @NonNull
    @Override
    public LecturersAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LecturersAdapterViewHolder(
                LecturersLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false)
        );
    }

    public LecturersAdapter (Context context,ArrayList Name, ArrayList Time, ArrayList Department, ArrayList Email) {
        this.context = context;
        this.Name = Name;
        this.Time = Time;
        this.Department = Department;
        this.Email = Email;
    }

    @Override
    public void onBindViewHolder(LecturersAdapterViewHolder holder, int position) {

        holder.lecturersLayoutBinding.name.setText(String.valueOf(Name.get(position)));
        holder.lecturersLayoutBinding.time.setText(String.valueOf(Time.get(position)));
        holder.lecturersLayoutBinding.department.setText(String.valueOf(Department.get(position)));
        holder.lecturersLayoutBinding.email.setText(String.valueOf(Email.get(position)));

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }
    public class LecturersAdapterViewHolder extends RecyclerView.ViewHolder {
        private final LecturersLayoutBinding lecturersLayoutBinding;

        public LecturersAdapterViewHolder(LecturersLayoutBinding lecturersLayoutBinding) {
            super(lecturersLayoutBinding.getRoot());
            this.lecturersLayoutBinding = lecturersLayoutBinding;
        }
    }
}
