package com.example.runnableapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.health.TimerStat;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private TextView tvTimePassed;
    private Button btnTimer;

    private boolean mTimerRunning;

    private long mTimePassedInMillis;

    Handler timerHandler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tvTimePassed.setText(String.valueOf(mTimePassedInMillis));
            timerHandler.postDelayed(this, 1000);
            mTimePassedInMillis++;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        tvTimePassed = findViewById(R.id.tvTimePassed);
        btnTimer = findViewById(R.id.btnTimer);
        mTimePassedInMillis = 0;

        btnTimer.setOnClickListener(v ->{
            if (btnTimer.getText().equals("stop")) {
                timerHandler.removeCallbacks(runnable);
                btnTimer.setText("start");
            } else {
                timerHandler.postDelayed(runnable, 0);
                btnTimer.setText("stop");
            }
        });
    }

}
