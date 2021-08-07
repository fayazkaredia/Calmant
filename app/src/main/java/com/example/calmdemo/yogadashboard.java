package com.example.calmdemo;



import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class yogadashboard extends AppCompatActivity {

    private Button exercisesButton, settingsButton;

    private ImageView trainingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yogadashboard);

        exercisesButton = (Button) findViewById(R.id.exercises_button);
        exercisesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(yogadashboard.this, ListExercisesActivity.class);
                startActivity(intent);
            }
        });

        settingsButton = (Button) findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(yogadashboard.this, SettingsActivity.class);
                startActivity(intent);
            }
        });



        trainingButton = (ImageView) findViewById(R.id.training_button);
        trainingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(yogadashboard.this, DailyTrainingActivity.class);
                startActivity(intent);
            }
        });
    }
}
