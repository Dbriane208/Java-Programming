package daniel.brian.gradingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String USERNAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = findViewById(R.id.btnNext);
        buttonStart.setOnClickListener(v -> {
            EditText userName = findViewById(R.id.userName);
             if(userName.getText().toString().isEmpty()){
                 Toast.makeText(MainActivity.this,"Please Enter your Name",Toast.LENGTH_SHORT).show();
             }else{
                 Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                 intent.putExtra(USERNAME,userName.getText().toString());
                 startActivity(intent);
             }
        });
    }
}