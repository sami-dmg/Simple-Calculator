package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private String current = "", operator = "";
    private double first = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
    }

    public void numberClick(View view) {
        Button btn = (Button) view;
        current += btn.getText().toString();
        result.setText(current);
    }

    public void clear(View view) {
        current = "";
        operator = "";
        first = 0;
        result.setText("0");
    }

    public void operatorClick(View view) {
        if (!current.isEmpty()) {
            first = Double.parseDouble(current);
            operator = ((Button) view).getText().toString();
            current = "";
        }
    }

    public void equal(View view) {
        if (!current.isEmpty()) {
            double second = Double.parseDouble(current);
            switch (operator) {
                case "+": current = String.valueOf(first + second); break;
                case "-": current = String.valueOf(first - second); break;
                case "×": current = String.valueOf(first * second); break;
                case "÷": current = second != 0 ? String.valueOf(first / second) : "Error"; break;
            }
            result.setText(current);
            operator = "";
        }
    }

    public void dot(View view) {
        if (!current.contains(".")) {
            if (current.isEmpty()) current = "0.";
            else current += ".";
            result.setText(current);
        }
    }

    public void plusMinus(View view) {
        if (!current.isEmpty()) {
            if (current.startsWith("-")) current = current.substring(1);
            else current = "-" + current;
            result.setText(current);
        }
    }

    public void percent(View view) {
        if (!current.isEmpty()) {
            double val = Double.parseDouble(current) / 100;
            current = String.valueOf(val);
            result.setText(current);
        }
    }
}