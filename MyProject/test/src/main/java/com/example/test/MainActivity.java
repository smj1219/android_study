package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int num;
    TextView currentNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNum = findViewById(R.id.currentNum);

        Button minusBtn=findViewById(R.id.minusBtn);
        Button plusBtn=findViewById(R.id.plusBtn);

        minusBtn.setOnClickListener(view -> {
            num--;
            String result = Integer.toString(num);
            currentNum.setText(result);
        });
        plusBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        num++;
        String strNum = Integer.toString(num);
        currentNum.setText(strNum);
    }
}