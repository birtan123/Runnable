package com.example.runnableapplication.zad3;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import java.util.Random;

public class ImageSimulate implements Runnable{

    TextView tvResult;
    ProgressBar progressBar;
    boolean bProcess;
    SimulateTaskListener simulateTaskListener;
    DialogFragmentLoader loaderFragment;
    FragmentManager fragmentManager;


    public ImageSimulate(FragmentManager fm, ProgressBar progressBar, SimulateTaskListener simulateTaskListener, TextView tvResult) {
        fragmentManager = fm;
        this.progressBar = progressBar;
        this.tvResult = tvResult;
        this.simulateTaskListener = simulateTaskListener;

    }

    @Override
    public void run() {
        final int random = new Random().nextInt(3) + 2;
        int iRandom = random;
        int i;
        for (i = 0; i < random; i++)
        {

            try {
                simulateTaskListener.Result(1);
                progressBar.setVisibility(View.VISIBLE);
                Thread.sleep(1000L);



                if (i == iRandom - 1) {
                    progressBar.setVisibility(View.INVISIBLE);
                    tvResult.setText("Successful");
                    simulateTaskListener.Result(0);
                    loaderFragment.dismiss();
                }

            }
            catch (Exception е) {
                bProcess = true;
            }

        }
       // bProcess = true;

    }
}
