package com.example.runnableapplication.zad3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.runnableapplication.R;

public class DialogFragmentLoader extends DialogFragment {
    public DialogFragmentLoader(){
        // Required empty public constructor
    }

    public static DialogFragmentLoader newInstance(int time) {
        DialogFragmentLoader customFragment = new DialogFragmentLoader();
        Bundle args = new Bundle();
        args.putInt("title", time);
        customFragment.setArguments(args);
        return customFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
