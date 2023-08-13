package com.example.mynewfragment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EditFragment extends Fragment {

    EditText editText1, editText2;
    Button button;
    Fragment fragment;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        editText1 = view.findViewById(R.id.editText1);
        editText2 = view.findViewById(R.id.editText2);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                int id = Integer.parseInt(editText2.getText().toString());

                fragment = new TextFragment(name,id);

                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame,new EditFragment()).replace(R.id.frame,fragment).commit();
            }
        });
        return view;
    }
}