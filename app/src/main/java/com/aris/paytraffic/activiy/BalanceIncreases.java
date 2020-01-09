package com.aris.paytraffic.activiy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.aris.paytraffic.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;



public class BalanceIncreases extends AppCompatActivity implements AdapterView.OnItemClickListener {


    IntentIntegrator scan;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    EditText myEdittext;
    ViewGroup myContainer;
    TextView myTextView;
    View view;
    Intent intent;
    Button SendEditTextValue;
    ImageView imageView;
    boolean visibility = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance_increases);


            imageView = findViewById(R.id.imageCam);
            SendEditTextValue = findViewById(R.id.btn_ireli_balance_increase);
            myEdittext = findViewById(R.id.digersedittest);
            SendEditTextValue.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    intent = new Intent(getApplicationContext(), QrPayments.class);
                    intent.putExtra("EdiTtEXTvALUE", myEdittext.getText().toString());
                    startActivity(intent);

                }
            });

            myContainer = findViewById(R.id.AnimationContainer);
            myTextView = findViewById(R.id.digersbalanstext);
            myEdittext = findViewById(R.id.digersedittest);
            view = findViewById(R.id.view7);

            Spinner spinner = (Spinner) findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.planets_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public void AnimateClick (View v){

            TransitionManager.beginDelayedTransition(myContainer);
            visibility = !visibility;
            myTextView.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
            myEdittext.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
            imageView.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
            view.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);


        }


        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
            }
        }

