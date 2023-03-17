package com.example.loginexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        ((MaterialButton)findViewById(R.id.go_to_quiz)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}