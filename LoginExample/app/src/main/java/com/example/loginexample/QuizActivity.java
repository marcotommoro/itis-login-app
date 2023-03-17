package com.example.loginexample;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    String[] questionTitles = {"What is the purpose of a VPN?", "Which of the following is not a programming language?", "What is the difference between RAM and ROM? ", "What is an IP address?"};
    String [][]options = {{"To secure data transmission between two devices",
                            "To connect two different networks",
                            "To remotely access a computer or network",
                            "To increase internet connection speed"},
                            {"Java", "C++", "Python", "HTML"},
                            {"RAM is volatile and ROM is non-volatile",
                            "RAM is non-volatile and ROM is volatile",
                            "RAM is faster than ROM",
                            "RAM is slower than ROM"},
                            {"A unique number assigned to a device",
                            "A unique number assigned to a network",
                            "A unique number assigned to a computer",
                            "A unique number assigned to a website"}};
    String []answers = {options[0][2], options[1][3], options[2][0], options[3][2]};
    final int N_OPTIONS = 4;
    ArrayList<MaterialButton> optionButtons;

    int progress = 0;
    int points = 0;
    String selectedOption = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizzz_activity);

        optionButtons = new ArrayList<>();

        for (int i = 0; i < N_OPTIONS; i++ ){
            optionButtons.add(findViewById(getResources().getIdentifier("option_"+(i+1), "id", getPackageName())));

            optionButtons.get(optionButtons.size()-1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedOption = ((MaterialButton) view).getText().toString();
                    //Put stroke on the view
                    removeStroke();
                    ((MaterialButton)view).setStrokeWidth(10);
                }
            });
        }

        findViewById(R.id.next_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedOption.equals("")) return;

                if (selectedOption.equals(answers[progress])){
                    points++;
                }

                progress++;

                if (progress < questionTitles.length){
                    updateQuestion();
                } else {
                    finishQuiz();
                }
            }
        });
    }

    void removeStroke(){
        for (int i = 0; i < N_OPTIONS; i++){
            optionButtons.get(i).setStrokeWidth(0);
        }
    }
    void updateQuestion(){
        selectedOption = "";

        ((TextView)findViewById(R.id.question)).setText(questionTitles[progress]);
        removeStroke();

        for (int i = 0; i < N_OPTIONS; i++){
            optionButtons.get(i).setText(options[progress][i]);
        }
    }

    void finishQuiz(){
        // TODO
    }
}
