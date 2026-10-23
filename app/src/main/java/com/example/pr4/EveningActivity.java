package com.example.pr4;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class EveningActivity extends AppCompatActivity {

    private static final int NOTIFY_ID_SLEEP = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evening);

        MyPushNotification push = new MyPushNotification(this,
                getSystemService(NotificationManager.class));
        push.sendNotify("СПАТЬ!", "Уже поздно. Пора отдыхать.", NOTIFY_ID_SLEEP);

        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(EveningActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
        btnNext.setOnClickListener(v ->
                startActivity(new Intent(EveningActivity.this, NightActivity.class)));
    }
}