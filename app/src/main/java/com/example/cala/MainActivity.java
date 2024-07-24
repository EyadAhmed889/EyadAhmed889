package com.example.cala;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
double firstNumber;
String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        Button num0 = findViewById(R.id.num_0);
        Button num1 = findViewById(R.id.num_1);
        Button num2 = findViewById(R.id.num_2);
        Button num3 = findViewById(R.id.num_3);
        Button num4 = findViewById(R.id.num_4);
        Button num5 = findViewById(R.id.num_5);
        Button num6 = findViewById(R.id.num_6);
        Button num7 = findViewById(R.id.num_7);
        Button num8 = findViewById(R.id.num_8);
        Button num9 = findViewById(R.id.num_9);
        Button dot = findViewById(R.id.dot);
        Button numDel = findViewById(R.id.del);
        Button numAc = findViewById(R.id.Ac);
        Button numEqual = findViewById(R.id.equal);
        Button numon = findViewById(R.id.on);
        Button OFF = findViewById(R.id.off);
        Button subtract = findViewById(R.id.subtract);
        Button plus = findViewById(R.id.plus);
        Button times = findViewById(R.id.times);
        Button div = findViewById(R.id.divided);
        TextView screen = findViewById(R.id.tx_Screen);
        numAc.setOnClickListener(view -> {
            firstNumber=0;
            screen.setText("0");
        });
        OFF.setOnClickListener(view -> screen.setVisibility(view.GONE));
        numon.setOnClickListener(view -> {
            screen.setVisibility(view.VISIBLE);
            screen.setText("0");
        });
        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button b : nums) {
            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }
        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(times);
        opers.add(plus);
        opers.add(subtract);
        for (Button b : opers) {
            b.setOnClickListener(view -> {
                firstNumber = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });

        }
        numDel.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length() > 1) {
                screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length() == 1 && !num.equals("0")) {
                screen.setText("0");

            }
        });
        dot.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")) {
                screen.setText(screen.getText().toString() + ".");

            }
        });
        View equals = null;
        numEqual.setOnClickListener(view -> {
            double secondNumber=Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation){
                case "/":
                    result=firstNumber/secondNumber;
                    break;
                case "*":
                    result=firstNumber*secondNumber;
                    break;
                case "+":
                    result=firstNumber+secondNumber;
                    break;
                case "-":
                    result=firstNumber-secondNumber;
                    break;
                default:
                    result=firstNumber+secondNumber;
            }screen.setText(String.valueOf(result));
            firstNumber=result;

        }) ;   }
}

