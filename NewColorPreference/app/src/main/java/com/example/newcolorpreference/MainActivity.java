package com.example.newcolorpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.layout);

        sharedPreferences = getSharedPreferences("colorPreference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        int color = sharedPreferences.getInt("color",0);
        constraintLayout.setBackgroundColor(color);
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.button1:constraintLayout.setBackgroundColor(Color.RED);
            editor.putInt("color",Color.RED);
            editor.commit();
            break;

            case R.id.button2:constraintLayout.setBackgroundColor(Color.GREEN);
            editor.putInt("color",Color.GREEN);
            editor.commit();
            break;

            case R.id.button3:constraintLayout.setBackgroundColor(Color.BLUE);
            editor.putInt("color",Color.BLUE);
            editor.commit();
            break;
        }
    }
}