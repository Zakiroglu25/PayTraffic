package com.aris.paytraffic.drawerMenu.addItem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aris.paytraffic.R;

/**
 * Created by rafael.meyer on 8/24/16.
 */
public class CardViewItemActivity extends Activity {

    private TextView nomeItem;
    private View viewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardviewitem);

        nomeItem = (TextView)findViewById(R.id.nomeId);
        viewColor = (View)findViewById(R.id.viewColor);

    }
}
