package com.example.pr4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission("android.permission.POST_NOTIFICATIONS")
                    != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                        new String[]{"android.permission.POST_NOTIFICATIONS"},
                        PERMISSION_REQUEST_CODE);
            }
        }

        Button btnMorning = findViewById(R.id.btnMorning);
        Button btnDay = findViewById(R.id.btnDay);
        Button btnEvening = findViewById(R.id.btnEvening);
        Button btnNight = findViewById(R.id.btnNight);

        btnMorning.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, MorningActivity.class)));

        btnDay.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, DayActivity.class)));

        btnEvening.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, EveningActivity.class)));

        btnNight.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, NightActivity.class)));
    }
}