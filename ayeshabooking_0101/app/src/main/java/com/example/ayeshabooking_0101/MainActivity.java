package com.example.ayeshabooking_0101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private Spinner TO;
    private Spinner FROM;
    Context Context = this;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TO=(Spinner)findViewById(R.id.TO) ;
        List<String> list = new ArrayList<String>();
        list.add("Bangalore");
        list.add("Hyderabad");
        list.add("Kerala");
        list.add("Mumbai");
        list.add("Delhi");
        list.add("Kolkota");
        list.add("Goa");
        FROM=(Spinner)findViewById(R.id.FROM);
        List<String> list1= new ArrayList<String>();
        list.add("Bangalore");
        list.add("Hyderabad");
        list.add("Kerala");
        list.add("Mumbai");
        list.add("Delhi");
        list.add("Kolkota");
        list.add("Goa");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,list);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,list1);

        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        FROM.setAdapter(dataAdapter1);
        FROM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Object obj = parent.getItemAtPosition(pos);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Context);
                SharedPreferences.Editor prefsEditor = prefs.edit();
                prefsEditor.putString("object", obj.toString());
                prefsEditor.commit();
            }
        });
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        TO.setAdapter(dataAdapter);
        TO.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Object obj = parent.getItemAtPosition(pos);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Context);
                SharedPreferences.Editor prefsEditor = prefs.edit();
                prefsEditor.putString("object", obj.toString());
                prefsEditor.commit();
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}