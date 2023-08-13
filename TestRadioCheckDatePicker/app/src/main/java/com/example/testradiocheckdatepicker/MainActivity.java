package com.example.testradiocheckdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox1,checkBox2,checkBox3;
    String mobile[]={"", "", ""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         checkBox1= findViewById(R.id.cb1);
         checkBox2= findViewById(R.id.cb2);
         checkBox3= findViewById(R.id.cb3);
    }
    public void getMobile(View view){
        int id = view.getId();

        switch(id){
            case R.id.cb1:
                if(checkBox1.isChecked())
                {
                    mobile[0]=checkBox1.getText().toString();
                }
                else{
                    mobile[0]="";
                }
                //Toast.makeText(this,checkBox1.getText(),Toast.LENGTH_LONG).show();
                break;
            case R.id.cb2:
                if(checkBox2.isChecked())
                {
                    mobile[1]=checkBox1.getText().toString();
                }
                else{
                    mobile[1]="";
                }
                //Toast.makeText(this,checkBox2.getText(), Toast.LENGTH_LONG).show();
                break;
            case R.id.cb3:
                if(checkBox3.isChecked()){
                    mobile[2]=checkBox3.getText().toString();
                }
                else{
                    mobile[2]="";
                }
                Toast.makeText(this,mobile[0],mobile[2],mobile[1],Toast.LENGTH_LONG).show();
                break;
        }
    }
}