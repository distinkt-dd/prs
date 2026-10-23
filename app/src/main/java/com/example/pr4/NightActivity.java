package com.example.pr4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);

        Button btnSecret = findViewById(R.id.btnSecret);
        btnSecret.setOnClickListener(v -> showSleepDialog());
    }

    private void showSleepDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Вопрос")
                .setMessage("Ты спишь?")
                .setPositiveButton("Да", (dialog, which) -> finishAffinity())
                .setNegativeButton("Нет", (dialog, which) -> {
                    Intent intent = new Intent(NightActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                })
                .setCancelable(false)
                .show();
    }
}