package com.example.runnableapplication.zad3;

import android.view.View;
import android.widget.ProgressBar;

import java.util.Random;

public class LoginSimulate implements Runnable{

    ProgressBar progressBar;

    public LoginSimulate(ProgressBar progressBar) {
        this.progressBar = progressBar;
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void run() {
        final int random = new Random().nextInt(3) + 2;

        for (int i = 0; i < random; i++)
        {

            try {
                Thread.sleep(1000L);
            }
            catch (Exception е) {

            }
        }
        progressBar.setVisibility(View.INVISIBLE);
    }
}
