package com.example.runnableapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.runnableapplication.zad3.SimulateActivity;

public class MainActivity extends AppCompatActivity {

    Button btnZad1, btnZad2, btnZad3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnZad1 = findViewById(R.id.btnZad1);
        btnZad2 = findViewById(R.id.btnZad2);
        btnZad3 = findViewById(R.id.btnZad3);

        btnZad1.setOnClickListener(v->{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        });

        btnZad2.setOnClickListener(v->{
            Intent intent = new Intent(this, TimerActivity.class);
            startActivity(intent);
        });

        btnZad3.setOnClickListener(v->{
            Intent intent = new Intent(this, SimulateActivity.class);
            startActivity(intent);
        });
    }
}
