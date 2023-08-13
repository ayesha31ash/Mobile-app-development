package com.example.mynewfragment1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {
    private String name;
    private  int id;
    TextView textView;

    public TextFragment(){

    }
    public TextFragment(String name, int id){
        this.name = name;
        this.id = id;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,Bundle savedInstanceState ) {
        View view = inflater.inflate(R.layout.fragment_text,container,false);
        textView = view.findViewById(R.id.textView);

        textView.setText("name:"+name + "ID:"+ id);
        return view;
    }
}