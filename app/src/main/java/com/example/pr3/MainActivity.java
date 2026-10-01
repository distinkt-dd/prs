package com.example.pr3;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4;
    TextView tvStudentInfo;
    private final String[] animals = {"Заяц", "Волк", "Корова", "Тигр", "Лошадь", "Лев"};
    private final boolean[] checkedItems = {false, false, false, false, false, false};
    private final ArrayList<Integer> correctAnswers = new ArrayList<>(Arrays.asList(0, 2, 4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        tvStudentInfo = findViewById(R.id.tvStudentInfo);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "кнопка номер 1 нажата", Toast.LENGTH_SHORT).show();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this, "кнопка номер 2 нажата", Toast.LENGTH_LONG);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("кнопка 3");
                builder.setIcon(R.drawable.test_icon);
                builder.setMessage("Это диалоговое окно. Выберите действие.");


                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        btn1.setTextColor(Color.RED);
                        btn2.setTextColor(Color.RED);
                        btn3.setTextColor(Color.RED);
                        btn4.setTextColor(Color.RED);
                        dialog.dismiss();
                    }
                });


                builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Окно закрыто", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.show();
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Выберите травоядных животных");


                Arrays.fill(checkedItems, false);

                builder.setMultiChoiceItems(animals, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                    }
                });

                builder.setPositiveButton("Проверить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        checkAnswers();
                    }
                });

                builder.setNegativeButton("Отмена", null);

                builder.show();
            }
        });
    }


    private void checkAnswers() {
        boolean allCorrect = true;

        for (int index : correctAnswers) {
            if (!checkedItems[index]) {
                allCorrect = false;
                break;
            }
        }


        for (int i = 0; i < checkedItems.length; i++) {
            if (checkedItems[i] && !correctAnswers.contains(i)) {
                allCorrect = false;
                break;
            }
        }

        if (allCorrect) {
            Toast.makeText(this, "Все верно!", Toast.LENGTH_SHORT).show();
        } else {

            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            Toast.makeText(this, "Ответ неверный. Кнопки скрыты.", Toast.LENGTH_SHORT).show();
        }
    }
}