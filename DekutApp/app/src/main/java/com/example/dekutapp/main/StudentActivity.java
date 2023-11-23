package com.example.dekutapp.main;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dekutapp.R;
import com.example.dekutapp.Student.StudentDashboardActivity;
import com.example.dekutapp.database.StudentsDB;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StudentActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri; // Declare selectedImageUri as a class-level variable
    private Bitmap selectedBitmap; // Declare selectedBitmap as a class-level variable

    private StudentsDB studentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentDB = new StudentsDB(this); // Create an instance of AdminDB

        EditText name = findViewById(R.id.studentName);
        EditText course = findViewById(R.id.course);
        EditText department = findViewById(R.id.department);
        EditText email = findViewById(R.id.email);
        Button documentButton = findViewById(R.id.documentBtn);
        Button post = findViewById(R.id.buttonSend);

        // Create an ActivityResultLauncher for galleryIntent
        ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        // Get the URI of the selected image
                        selectedImageUri = data.getData();

                        // Convert the selected image to a Bitmap
                        try {
                            selectedBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        // Handle the selected image
                        Toast.makeText(StudentActivity.this, "Document selected!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        documentButton.setOnClickListener(view -> {
            openGallery(galleryLauncher);
        });

        post.setOnClickListener(view -> {
            // Validate input fields
            String Name = name.getText().toString().trim();
            String Course = course.getText().toString().trim();
            String Department = department.getText().toString().trim();
            String Email = email.getText().toString().trim();

            if (Name.isEmpty() || Course.isEmpty() || Department.isEmpty() || Email.isEmpty()) {
                Toast.makeText(this, "Please Enter all Fields", Toast.LENGTH_LONG).show();
            } else {
                // Insert Document data into the database
                try {

                    // Check if an image document is selected
                    if (selectedBitmap != null) {
                        // Convert the selected image to a byte array
                        byte[] imageData = convertImageToByteArray(selectedImageUri);

                        boolean insert = studentDB.insertStudentData(Name, Course, Department, Email, imageData);

                        if (insert) {
                            // Document inserted successfully
                            Toast.makeText(this, "Document Added Successfully", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(this, StudentDashboardActivity.class);
                            startActivity(intent);
                        } else {
                            // Failed to insert document
                            Toast.makeText(this, "Failed to Add Document", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        // Show a message if no image is selected
                        Toast.makeText(this, "Please select a document", Toast.LENGTH_LONG).show();
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where the entered price is not a valid number
                    Toast.makeText(this, "Invalid Price Format", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void openGallery(ActivityResultLauncher<Intent> launcher) {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        launcher.launch(galleryIntent);
    }

    private byte[] convertImageToByteArray(Uri uri) {
        try {
            ContentResolver contentResolver = getContentResolver();
            InputStream inputStream = contentResolver.openInputStream(uri);

            // Convert InputStream to byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            byteArrayOutputStream.close();

            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        // Close the database connection when the activity is destroyed
        studentDB.close();
        super.onDestroy();
    }

}
