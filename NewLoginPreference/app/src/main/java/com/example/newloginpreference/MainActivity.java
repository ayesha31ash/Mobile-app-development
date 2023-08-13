package com.example.newloginpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    String userName, password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText1 = findViewById(R.id.editTextTextPersonName);
        editText2 = findViewById(R.id.editTextTextPassword);

        sharedPreferences = getSharedPreferences("loginPreference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        userName = sharedPreferences.getString("userName","");
        password = sharedPreferences.getString("password","");
        editText1.setText(sharedPreferences.getString("userName",""));
        editText2.setText(sharedPreferences.getString("password",""));

        editText1.setText(userName);
        editText2.setText(password);
    }
    public void onClick(View view){
        userName = editText1.getText().toString();
        password = editText2.getText().toString();

        if (userName.equals("khan")&& password.equals("khan")){
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,SecondActivity.class);

            editor.putString("userName",userName);
            editor.putString("password",password);
            editor.commit();

            startActivity(intent);
        }
    }
}
