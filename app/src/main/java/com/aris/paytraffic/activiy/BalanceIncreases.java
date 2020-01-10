package com.aris.paytraffic.activiy;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.aris.paytraffic.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;


public class BalanceIncreases extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {


    EditText myEdittext;
    ViewGroup myContainer;
    TextView myTextView;
    View view;
    Intent intent;
    EditText meblegEditText;
    Button SendEditTextValue;
    Button buttonIncreaseOtherBalance;
    ImageView imageView;
    boolean visibility = false;
    private IntentIntegrator qrScan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_increases);

        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        myChildToolbar.setNavigationOnClickListener(view -> onBackPressed());

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        imageView = findViewById(R.id.imageCam);
        SendEditTextValue = findViewById(R.id.btn_ireli_balance_increase);
        myEdittext = findViewById(R.id.digersedittest);
        myTextView = findViewById(R.id.digersbalanstext);
        view = findViewById(R.id.view7);


        buttonIncreaseOtherBalance = findViewById(R.id.buttonIncreaseOtherBalance);

        buttonIncreaseOtherBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimateClick();
            }
        });







        SendEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), QrPayments.class);
                intent.putExtra("EdiTtEXTvALUE", myEdittext.getText().toString());
                startActivity(intent);
            }
        });
        qrScan = new IntentIntegrator(this);
        imageView.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void AnimateClick() {
      //  TransitionManager.beginDelayedTransition(myContainer);
        visibility = !visibility;
        myTextView.setVisibility(visibility ? View.VISIBLE : View.GONE);
        myEdittext.setVisibility(visibility ? View.VISIBLE : View.GONE);
        imageView.setVisibility(visibility ? View.VISIBLE : View.GONE);
        view.setVisibility(visibility ? View.VISIBLE : View.GONE);
    }


    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    myEdittext.setText(obj.getString("code"));
                } catch (JSONException e) {
                    e.printStackTrace();

                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();


        myContainer = findViewById(R.id.AnimationContainer);
        myTextView = findViewById(R.id.digersbalanstext);
        myEdittext = findViewById(R.id.digersedittest);
        view = findViewById(R.id.view7);



    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }
}

