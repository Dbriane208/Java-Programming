package daniel.brian.potatodisease;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import daniel.brian.potatodisease.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;

    FirebaseAuth auth;
    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        binding.textLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

        binding.btnRegister.setOnClickListener(v -> {
            String username = Objects.requireNonNull(binding.username.getText()).toString();
            String email = Objects.requireNonNull(binding.email.getText()).toString().trim();
            String password = Objects.requireNonNull(binding.password.getText()).toString();

            if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
                Toast.makeText(this,"Please Enter all fields",Toast.LENGTH_SHORT).show();
            }else{
                registerFunction(username,email,password);
            }

        });

    }

    private void registerFunction(String username, String email, String password) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(this,"User registered successfully",Toast.LENGTH_SHORT).show();
                saveUser(username,email);
            }else{
                Toast.makeText(this,"Registration failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveUser(String username, String email) {
        Map<String,Object> user = new HashMap<>();
        user.put("username",username);
        user.put("email",email);

        firestore.collection("users").add(user).addOnSuccessListener(aVoid -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }).addOnFailureListener(e -> Toast.makeText(this, "User not saved successfully", Toast.LENGTH_LONG).show());
    }
}
