package com.aris.paytraffic.drawerMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.aris.paytraffic.R;

public class BonuceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bonuce);

        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        myChildToolbar.setNavigationOnClickListener(view -> onBackPressed());

    }
}
