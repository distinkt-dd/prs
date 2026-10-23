package com.example.pr4;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DayActivity extends AppCompatActivity {

    private static final int NOTIFY_ID_WORK_END = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        MyPushNotification push = new MyPushNotification(this,
                getSystemService(NotificationManager.class));
        push.sendNotify("Скоро конец рабочего дня!",
                "Пора завершать дела и готовиться к вечеру.",
                NOTIFY_ID_WORK_END);

        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(DayActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
        btnNext.setOnClickListener(v ->
                startActivity(new Intent(DayActivity.this, EveningActivity.class)));
    }
}