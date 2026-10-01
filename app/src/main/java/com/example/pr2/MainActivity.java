package com.example.pr2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvOperator, tvResult;
    private String currentOperator = "+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvOperator = findViewById(R.id.tvOperator);
        tvResult = findViewById(R.id.tvResult);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);
        Button btnClear = findViewById(R.id.btnClear);

        btnAdd.setOnClickListener(v -> setOperator("+"));
        btnSub.setOnClickListener(v -> setOperator("-"));
        btnMul.setOnClickListener(v -> setOperator("*"));
        btnDiv.setOnClickListener(v -> setOperator("/"));

        btnClear.setOnClickListener(v -> {
            etNum1.setText("");
            etNum2.setText("");
            tvResult.setText("=");
            tvOperator.setText("+");
            currentOperator = "+";
        });

        etNum1.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) { calculateResult(); }
        });

        etNum2.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override public void afterTextChanged(Editable s) { calculateResult(); }
        });
    }

    private void setOperator(String operator) {
        currentOperator = operator;
        tvOperator.setText(operator);
        calculateResult();
    }

    private void calculateResult() {
        String strNum1 = etNum1.getText().toString().trim();
        String strNum2 = etNum2.getText().toString().trim();

        if (strNum1.isEmpty() || strNum2.isEmpty()) {
            tvResult.setText("=");
            return;
        }

        try {
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);
            double result = 0;

            switch (currentOperator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        tvResult.setText("Ошибка: деление на ноль");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            String formatted;
            if (result == (long) result) {
                formatted = String.format("= %d", (long) result);
            } else {
                formatted = String.format("= %.2f", result);
            }
            tvResult.setText(formatted);

        } catch (NumberFormatException e) {
            tvResult.setText("=");
        }
    }
}