package com.example.pr1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView textViewGroup;
    TextView textViewFio;
    ImageView mainPng;
    Button hiddenButton;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewGroup = findViewById(R.id.textView2);
        textViewFio = findViewById(R.id.textView);
        mainPng = findViewById(R.id.imageView);
        hiddenButton = findViewById(R.id.button);
        imageButton = findViewById(R.id.imageButton);
    }

    @Override
    protected void onStart() {
        super.onStart();

        hiddenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textViewFio.getVisibility() == View.VISIBLE) {
                    textViewFio.setVisibility(View.GONE);
                    textViewGroup.setVisibility(View.GONE);

                } else {
                    textViewFio.setVisibility(View.VISIBLE);
                    textViewGroup.setVisibility(View.VISIBLE);
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainPng.getVisibility() == View.VISIBLE) {
                    mainPng.setVisibility(View.GONE);
                } else {
                    mainPng.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}