package com.example.bankingnotification_101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.NotificationManager;
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(10);
    }
}
