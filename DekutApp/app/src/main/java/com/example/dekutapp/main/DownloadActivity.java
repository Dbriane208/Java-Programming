package com.example.dekutapp.main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.dekutapp.databinding.ActivityDownloadBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE = 101;
    ActivityDownloadBinding activityDownloadBinding;
    byte[] imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDownloadBinding = ActivityDownloadBinding.inflate(getLayoutInflater());
        setContentView(activityDownloadBinding.getRoot());

        imageData = getIntent().getByteArrayExtra("imageData");

        if (imageData != null) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
            activityDownloadBinding.assignment.setImageBitmap(bitmap);
        }

        activityDownloadBinding.downloadImage.setOnClickListener(view -> {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_WRITE_EXTERNAL_STORAGE);
            } else {
                // Permission is already granted, proceed with saving the image
                saveImageToStorage();
            }
        });
    }

    private void saveImageToStorage() {
        if (imageData != null) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                // Use an existing directory, such as Pictures
                File directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String filename = "download_image_" + System.currentTimeMillis() + ".png";

                File file = new File(directory, filename);

                // Ensure the file is not null before attempting to create a FileOutputStream
                if (file != null) {
                    try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                        Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                        Toast.makeText(DownloadActivity.this, "Assignment downloaded to " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(DownloadActivity.this, "Error Downloading Assignment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DownloadActivity.this, "Error creating file", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
}