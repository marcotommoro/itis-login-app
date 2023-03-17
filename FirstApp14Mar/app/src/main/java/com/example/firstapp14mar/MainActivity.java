package com.example.firstapp14mar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username =(EditText) findViewById(R.id.username);

        MaterialButton loginButton = (MaterialButton) findViewById(R.id.login) ;

        TextView testoSotto = (TextView) findViewById(R.id.scritta_sotto);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ok va");
                String user = username.getText().toString();
                System.out.println("username "+ user);

                testoSotto.setText("HOLA!");

                Toast.makeText(getApplicationContext(),"ciaociao", Toast.LENGTH_LONG).show();

            }
        });
    }
}