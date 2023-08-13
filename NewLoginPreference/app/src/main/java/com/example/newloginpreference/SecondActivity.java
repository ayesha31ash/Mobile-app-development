package com.example.newloginpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.texView);

        sharedPreferences = getSharedPreferences("loginPreference", Context.MODE_PRIVATE);

        String userName = sharedPreferences.getString("userName","");

        textView.setText("Dear"+userName+",welcome to Mobile Application class, Its very enjoyable");
    }
}