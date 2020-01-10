package com.aris.paytraffic.activiy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aris.paytraffic.MainActivity;
import com.aris.paytraffic.R;

public class DonePayments extends AppCompatActivity {


    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_payments);

        imageView = findViewById(R.id.imageClose);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DonePayments.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
