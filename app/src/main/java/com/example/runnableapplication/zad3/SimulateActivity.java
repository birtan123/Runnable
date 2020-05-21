package com.example.runnableapplication.zad3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.runnableapplication.R;

public class SimulateActivity extends AppCompatActivity implements SimulateTaskListener {

    ProgressBar progressBar;
    Button btnSimulate;
    TextView tvResult;
    Handler handler = new Handler();
    boolean bProcess, bImage0, bLogin0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulate);

        progressBar = findViewById(R.id.progressBar);
        btnSimulate = findViewById(R.id.btnSimulate);
        tvResult = findViewById(R.id.tvResultSimulate);

        btnSimulate.setOnClickListener(v -> {
            bProcess = false;

            SupportDialogRunnable supportDialogRunnable = new SupportDialogRunnable(getSupportFragmentManager());
            Thread thread1 = new Thread(supportDialogRunnable);

            runOnUiThread(thread1);
            ImageSimulate oImageSimulate = new ImageSimulate(getSupportFragmentManager(), progressBar, this, tvResult);
        //    LoginSimulate oLoginSimulate = new LoginSimulate(progressBar);
            Thread thread = new Thread(oImageSimulate);

        //    Thread thread1 = new Thread(oLoginSimulate);
          //  handler.post(thread);
          //  thread.start();
            runOnUiThread(thread);
        });


        if(bProcess){
            handler.notify();
            tvResult.setText("Success");
            handler.notify();
        }
    }

    @Override
    public void Result(int value) {
        if(value == 0) {
            tvResult.setText("Success");
            progressBar.setVisibility(View.INVISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void bImage(boolean b) {
        bImage0 = b;
    }

    @Override
    public void bLogin(boolean b) {
        bLogin0 = b;
    }
}
