package com.example.runnableapplication;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginTask implements Runnable {
    String strCheck;
    TextView tvResult;
    EditText etPassword, etMail;
    char cString;
    private static final String TAG = "LoginTask";

    public LoginTask(TextView tvResult, EditText etPassword, EditText etMail) {
        this.tvResult = tvResult;
        this.etPassword = etPassword;
        this.etMail = etMail;
    }

    @Override
    public void run() {
        strCheck = this.etPassword.getText().toString();
        for (int i = 0; i <= strCheck.length(); i++) {
            if (strCheck.length() < 16) {
                tvResult.setText("Password too short");
                break;
            }
            cString = strCheck.charAt(i);

            Log.i(TAG, "run: " + (cString));
            if (i != 0) {
                if(!strCheck.substring(i, 1).matches("[!,@,#,$,%,&,* ]") && i % 8 == 0){
                    tvResult.setText("Every 8th character should be a special character");
                    break;
                }
                if (!Character.isDigit(cString) && i % 3 == 0) {
                    tvResult.setText("Every 3rd character should be a number");
                    break;
                }
                if (!Character.isUpperCase(cString) && i % 7 == 0) {
                    tvResult.setText("Every 7th character should be a Capital letter");
                    break;
                }
            } else {
                tvResult.setText(etMail.getText().toString() + "\n" + etPassword.getText().toString());
                break;
            }
        }
    }
}
