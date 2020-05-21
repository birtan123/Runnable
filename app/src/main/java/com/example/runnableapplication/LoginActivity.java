package com.example.runnableapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextView tvResult;
    private EditText etPassword, etMail;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvResult = findViewById(R.id.tvResultZad1);
        etPassword = findViewById(R.id.etPassword);
        btnResult = findViewById(R.id.btnResultZad1);
        etMail = findViewById(R.id.etEMail);




        btnResult.setOnClickListener(v->{
                LoginTask taskToRun = new LoginTask(tvResult, etPassword, etMail);
                Thread thread = new Thread(taskToRun);
                runOnUiThread(thread);
        });
        //thread.start();

    }
}
