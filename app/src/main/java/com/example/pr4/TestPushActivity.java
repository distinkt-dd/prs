package com.example.pr4;

import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TestPushActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_push);

        Bundle args = getIntent().getExtras();
        if (args != null) {
            int a = args.getInt("key1");
            Toast.makeText(getApplicationContext(), String.valueOf(a), Toast.LENGTH_LONG).show();
        }

        MyPushNotification myPushNotification = new MyPushNotification(this,
                getSystemService(NotificationManager.class));

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view ->
                myPushNotification.sendNotify("Первый пуш", "проверка"));
    }
}