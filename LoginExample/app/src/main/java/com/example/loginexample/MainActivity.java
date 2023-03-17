package com.example.loginexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String DEFAULT_USER = "admin";
    private String DEFAULT_PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);
        MaterialButton login = (MaterialButton) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ciaooo");
                if(true || !username.getText().toString().equals(DEFAULT_USER) || !password.getText().toString().equals(DEFAULT_PASSWORD)){
                    switchActivity();
                    launchToast("Welcome "+ DEFAULT_USER.toUpperCase(Locale.ROOT));
                }

            }
        });
    }

    private String getSHA256(String password){
        try {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest("admin".getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return null;
    }

    private static String bytesToHex(byte[] hash) {

        
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private void switchActivity(){
        Intent switchActivityIntent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(switchActivityIntent);
    }

    private void launchToast(String text){
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG);
        toast.show();
    }
}