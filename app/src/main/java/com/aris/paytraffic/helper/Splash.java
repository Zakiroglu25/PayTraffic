package com.aris.paytraffic.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.aris.paytraffic.auth.LoginActivity;
import com.aris.paytraffic.R;

public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Splash.this, LoginActivity.class);
                startActivity(homeIntent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}