package com.example.runnableapplication.zad3;

import androidx.fragment.app.FragmentManager;

public class SupportDialogRunnable implements Runnable {
    DialogFragmentLoader loaderFragment;
    FragmentManager fragmentManager;

    public SupportDialogRunnable(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void run() {
        loaderFragment = DialogFragmentLoader.newInstance(1);
        loaderFragment.show(fragmentManager, "dialog");
    }
}
