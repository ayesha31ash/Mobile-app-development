package com.example.bankingnotification_101;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    NotificationChannel notificationChannel;
    NotificationManager notificationManager;
    NotificationCompat.Builder builder;
    PendingIntent pendingIntent;
    String channel_id;
    String channel_name;
    int channel_importance;
    int notificationId = 10;
    EditText balanceInput;
    int minBalance = 5000;
    int curBalance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        channel_id = "my_ch";
        channel_name = "MyChannel";
        channel_importance = NotificationManager.IMPORTANCE_HIGH;

        balanceInput = findViewById(R.id.editText1);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify_101(View view) {
        curBalance = Integer.parseInt(balanceInput.getText().toString());
        if (curBalance < minBalance) {
            notificationChannel = new NotificationChannel(channel_id,channel_name,channel_importance);

            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            notificationManager.createNotificationChannel(notificationChannel);

            builder = new NotificationCompat.Builder(this, channel_id);
            Intent intent = new Intent(this,SecondActivity.class);
            pendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);

            builder.setSmallIcon(R.drawable.ic_launcher_background);
            builder.setContentTitle("Bank_101: Low Balance");
            builder.setContentText("");
            builder.setContentIntent(pendingIntent);
            builder.setStyle(new NotificationCompat.BigTextStyle().bigText("Your account balance is "+curBalance+".Maintain a minimum of 5000 balance to continue the service"));

            Notification notification = builder.build();

            notificationManager.notify(notificationId,notification);
        }

    }
}