package com.aris.paytraffic.drawerMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.aris.paytraffic.R;
import com.aris.paytraffic.drawerMenu.model.RecyclerViewAdapter;

import java.util.ArrayList;

public class PaymentsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    int[] arr ={R.drawable.kk,R.drawable.kk,R.drawable.kk,R.drawable.kk,R.drawable.kk,R.drawable.kk,R.drawable.kk,R.drawable.kk,R.drawable.kk,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(arr);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }
}
