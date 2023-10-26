package daniel.brian.gradingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    // Creating Constants to send Grades to next screen
    public static final String MOBILE = "mobileScore";
    public static final String PM = "pmScore";
    public static final String RESEARCH = "rmScore";
    public static final String MULTIMEDIA = "msScore";
    public static final String MIS = "misScore";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Getting the components by Id
        TextView homeUserName = findViewById(R.id.userName);
        Button calculateGrade = findViewById(R.id.btnNext);
        EditText mobileScore = findViewById(R.id.mobileScore);
        EditText pmScore = findViewById(R.id.pmScore);
        EditText rmScore = findViewById(R.id.rmScore);
        EditText msScore = findViewById(R.id.msScore);
        EditText misScore = findViewById(R.id.misScore);


        // Receiving the username text from main activity and setting it on the home activity
        Intent intent = getIntent();
        String receivedUserName = intent.getStringExtra(MainActivity.USERNAME);
        homeUserName.setText(receivedUserName);

        // Sending the Scores to the Results Activity to be Graded
        calculateGrade.setOnClickListener(v -> {
            Intent intentSendScore = new Intent(HomeActivity.this, ResultsActivity.class);
            intentSendScore.putExtra(MOBILE,mobileScore.getText().toString());
            intentSendScore.putExtra(PM,pmScore.getText().toString());
            intentSendScore.putExtra(RESEARCH,rmScore.getText().toString());
            intentSendScore.putExtra(MULTIMEDIA,msScore.getText().toString());
            intentSendScore.putExtra(MIS,misScore.getText().toString());
            startActivity(intentSendScore);
        });


    }
}