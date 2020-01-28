package com.aris.paytraffic.activiy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.R;
import com.aris.paytraffic.activiy.recyclerviewAdapter.KabelTvRVAdapter;
import com.aris.paytraffic.activiy.recyclerviewAdapter.MobileOperatorRecyclerAdapter;
import com.aris.paytraffic.drawerMenu.model.Category;

import java.util.ArrayList;
import java.util.List;

public class KabelTv extends AppCompatActivity {

    private RecyclerView recyclerView;
    MobileOperatorRecyclerAdapter mobileOperatorRecyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabel_tv);



        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        myChildToolbar.setNavigationOnClickListener(view -> onBackPressed());


        categoryList = new ArrayList<>();
        categoryList.add(new Category("Ailə TV" , R.drawable.ailetv));
        categoryList.add(new Category("AlBax TV" , R.drawable.al_bax));
        categoryList.add(new Category("Alfanet TV" , R.drawable.alfa_net));
        categoryList.add(new Category("ATV+ " , R.drawable.atv_plus));
        categoryList.add(new Category("Azəri TV " , R.drawable.azeri_tv));
        categoryList.add(new Category("B&B TV " , R.drawable.bb));
        categoryList.add(new Category("Bactelecom " , R.drawable.baktelecom_logo));
        categoryList.add(new Category("İPTV " , R.drawable.smart_ip));
        categoryList.add(new Category("BuludStore " , R.drawable.bulud_store));
        categoryList.add(new Category("Cityline TV " , R.drawable.city_line));
        categoryList.add(new Category("CLIP TV " , R.drawable.clip_tv));
        categoryList.add(new Category("Connect tv " , R.drawable.connect));
        categoryList.add(new Category("Fiber TV " , R.drawable.television));
        categoryList.add(new Category("Izone TV " , R.drawable.i_zona));
        categoryList.add(new Category("K22 " , R.drawable.k_22));
        categoryList.add(new Category("KATV 1 " , R.drawable.k_tv));
        categoryList.add(new Category("Nar TV " , R.drawable.nar_tv));
        categoryList.add(new Category("NNTV " , R.drawable.nn_tv));
        categoryList.add(new Category("ODTV " , R.drawable.television));
        categoryList.add(new Category("Rahat Telecom " , R.drawable.rahat_telekom));
        categoryList.add(new Category("Shakk TV " , R.drawable.television));
        categoryList.add(new Category("Smar TV Plus " , R.drawable.smart_ip));


        KabelTvRVAdapter kabelTvRVAdapter = new KabelTvRVAdapter(categoryList);

        recyclerView = findViewById(R.id.recyclerViewMobile);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(kabelTvRVAdapter);



    }
}
