package daniel.brian.gradingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Getting the TextViews to map the received Data
        TextView mobileScore = findViewById(R.id.mobileScore);
        TextView pmScore = findViewById(R.id.pmScore);
        TextView rmScore = findViewById(R.id.rmScore);
        TextView msScore = findViewById(R.id.msScore);
        TextView misScore = findViewById(R.id.misScore);

        // Getting the passed Intents from HomeActivity
        Intent intent = getIntent();

        String receivedMobileScore = intent.getStringExtra(HomeActivity.MOBILE);
        mobileScore.setText(receivedMobileScore);

        String receivedPmScore = intent.getStringExtra(HomeActivity.PM);
        pmScore.setText(receivedPmScore);

        String receivedRmScore = intent.getStringExtra(HomeActivity.RESEARCH);
        rmScore.setText(receivedRmScore);

        String receivedMsScore = intent.getStringExtra(HomeActivity.MULTIMEDIA);
        msScore.setText(receivedMsScore);

        String receivedMisScore = intent.getStringExtra(HomeActivity.MIS);
        misScore.setText(receivedMisScore);

       // Making our grades double for MobileScore
        double mobileUnit = Double.parseDouble(mobileScore.getText().toString());
        TextView mobileGrade = findViewById(R.id.mobileGrade);

        if(mobileUnit >= 70 && mobileUnit <= 100){
            mobileGrade.setText("A");
        } else if (mobileUnit >= 60 && mobileUnit < 70) {
            mobileGrade.setText("B");
        } else if (mobileUnit >= 50 && mobileUnit < 60) {
            mobileGrade.setText("C");
        } else if (mobileUnit >= 40 && mobileUnit < 50) {
            mobileGrade.setText("D");
        } else if(mobileUnit > 100){
            mobileGrade.setText("Error");
        }else{
            mobileGrade.setText("E");
        }

        // Making our grades double for pmScore
        double pmUnit = Double.parseDouble(pmScore.getText().toString());
        TextView pmGrade = findViewById(R.id.pmGrade);

        if(pmUnit >= 70 && pmUnit <= 100){
            pmGrade.setText("A");
        } else if (pmUnit >= 60 && pmUnit < 70) {
            pmGrade.setText("B");
        } else if (pmUnit >= 50 && pmUnit < 60) {
            pmGrade.setText("C");
        } else if (pmUnit >= 40 && pmUnit < 50) {
            pmGrade.setText("D");
        } else if (pmUnit > 100){
            pmGrade.setText("Error");
        } else{
            pmGrade.setText("E");
        }

        // Making our grades double for rmScore
        double rmUnit = Double.parseDouble(rmScore.getText().toString());
        TextView rmGrade = findViewById(R.id.rmGrade);

        if(rmUnit >= 70 && rmUnit <= 100){
            rmGrade.setText("A");
        } else if (rmUnit >= 60 && rmUnit < 70) {
            rmGrade.setText("B");
        } else if (rmUnit >= 50 && rmUnit < 60) {
            rmGrade.setText("C");
        } else if (rmUnit >= 40 && rmUnit < 50) {
            rmGrade.setText("D");
        } else if (rmUnit > 100){
            rmGrade.setText("Error");
        } else{
            rmGrade.setText("E");
        }

        // Making our grades double for msScore
        double msUnit = Double.parseDouble(msScore.getText().toString());
        TextView msGrade = findViewById(R.id.msGrade);

        if(msUnit >= 70 && msUnit <= 100){
            msGrade.setText("A");
        } else if (msUnit >= 60 && msUnit < 70) {
            msGrade.setText("B");
        } else if (msUnit >= 50 && msUnit < 60) {
            msGrade.setText("C");
        } else if (msUnit >= 40 && msUnit < 50) {
            msGrade.setText("D");
        } else if (msUnit > 100){
            msGrade.setText("Error");
        } else{
            msGrade.setText("E");
        }

        // Making our grades double for misScore
        double misUnit = Double.parseDouble(misScore.getText().toString());
        TextView misGrade = findViewById(R.id.misGrade);

        if(misUnit >= 70 && misUnit <= 100){
            misGrade.setText("A");
        } else if (misUnit >= 60 && misUnit < 70) {
            misGrade.setText("B");
        } else if (misUnit >= 50 && misUnit < 60) {
            misGrade.setText("C");
        } else if (misUnit >= 40 && misUnit < 50) {
            misGrade.setText("D");
        } else if (misUnit > 100){
            misGrade.setText("Error");
        } else{
            misGrade.setText("E");
        }

        // Getting the total score
        double totalScore = mobileUnit + pmUnit + rmUnit + msUnit + misUnit;
        TextView totalScoreResult = findViewById(R.id.meanScore);

        String totalScoreText = String.valueOf(totalScore);
        totalScoreResult.setText(totalScoreText);

        // Getting the mean Grade
        double meanScore = totalScore/5;
        TextView meanGrade = findViewById(R.id.meanGrade);

        if(meanScore >= 70 && meanScore <= 100){
            meanGrade.setText("A");
        } else if (meanScore >= 60 && meanScore < 70) {
            meanGrade.setText("B");
        } else if (meanScore >= 50 && meanScore < 60) {
            meanGrade.setText("C");
        } else if (meanScore >= 40 && meanScore < 50) {
            meanGrade.setText("D");
        } else if(meanScore > 500) {
            meanGrade.setText("Error");
        } else{
            meanGrade.setText("E");
        }

        // Adding functionality to Back Button
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> onBackPressed());

        // Adding functionality to Exit Button
        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(v -> {
            Intent intent1 = new Intent(ResultsActivity.this,MainActivity.class);
            startActivity(intent1);
        });


    }
}