package com.aris.paytraffic.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aris.paytraffic.R;

public class PhoneCode extends AppCompatActivity  {

    private CountDownTimer countDownTimer;
    public TextView text;
    private int count = 60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_code);
        text= findViewById(R.id.timer);

        Button button = findViewById(R.id.restartcode);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneCode.this, Register.class);
                startActivity(intent);
            }
        });


        CountDownTimer countDownTimer = new CountDownTimer(60*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
//                text.setText();
                text.setText(count+"");
                count --;
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();


    }

}
