package com.example.homework31;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Calculator calculator;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] numberIds = new int[]{
                R.id.zero,
                R.id.two,
                R.id.three,
                R.id.four,
                R.id.five,
                R.id.six,
                R.id.seven,
                R.id.eight,
                R.id.nine,
        };
        int[] actionIds = new int[]{
                R.id.minus,
                R.id.plus,
                R.id.multiply,
                R.id.division,
                R.id.equals
        };
        text = findViewById(R.id.text);
        calculator = new Calculator();
        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());

            }
        };
        View.OnClickListener actionButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };
        for (int i = 0; i < numberIds.length; i++) {
            findViewById(numberIds[i]).setOnClickListener(numberButtonClickListener);

        }
        for (int i = 0; i < actionIds.length; i++) {
            findViewById(actionIds[i]).setOnClickListener(actionButtonListener);

        }
    }
}
