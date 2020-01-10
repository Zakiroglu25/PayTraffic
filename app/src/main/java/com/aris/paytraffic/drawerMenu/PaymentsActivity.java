package com.aris.paytraffic.drawerMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.aris.paytraffic.R;
import com.aris.paytraffic.adapter.RecyclerViewAdapter;
import com.aris.paytraffic.drawerMenu.model.Category;

import java.util.ArrayList;
import java.util.List;


public class PaymentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Category> categoryList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);


        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        myChildToolbar.setNavigationOnClickListener(view -> onBackPressed());

        //initialize every thing first
        categoryList = new ArrayList<>();
        //add animals to our animalsList
        categoryList.add(new Category("QR Kodla ödə" , R.drawable.qr_code));
        categoryList.add(new Category("Mobil" , R.drawable.payments_phone));
        categoryList.add(new Category("Kabel TV" , R.drawable.television));
        categoryList.add(new Category("Telefon" , R.drawable.phone_alt));
        categoryList.add(new Category("Kommunal" , R.drawable.construction));
        categoryList.add(new Category("İnternet" , R.drawable.global));
        categoryList.add(new Category("Nəqliyyat" , R.drawable.sports_car));
        categoryList.add(new Category("Sığorta" , R.drawable.unbrella));
        categoryList.add(new Category("Dövlət ödənişləri" , R.drawable.note));
        categoryList.add(new Category("Naxçıvan MR" , R.drawable.flag));
        categoryList.add(new Category("Bank ödənişləri" , R.drawable.money));
        categoryList.add(new Category("Təhsil" , R.drawable.college));

        //initialize the adapter with list of animals
        recyclerViewAdapter = new RecyclerViewAdapter(categoryList);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        //set recycler layout manager to decide it will scroll vertically or horizontally
        //add linear layout  manager to make it vertical
        recyclerView.setLayoutManager(layoutManager);

        //add our adapter to the recyclerView to start showing items
        recyclerView.setAdapter(recyclerViewAdapter);




    }

}
