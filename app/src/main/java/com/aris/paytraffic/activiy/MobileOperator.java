package com.aris.paytraffic.activiy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.R;
import com.aris.paytraffic.activiy.recyclerviewAdapter.MobileOperatorRecyclerAdapter;
import com.aris.paytraffic.drawerMenu.model.Category;

import java.util.ArrayList;
import java.util.List;

public class MobileOperator extends AppCompatActivity {

    private RecyclerView recyclerView;
    MobileOperatorRecyclerAdapter mobileOperatorRecyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Category> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_operator);


        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        myChildToolbar.setNavigationOnClickListener(view -> onBackPressed());


        categoryList = new ArrayList<>();
        categoryList.add(new Category("Azercell" , R.drawable.azercell_png));
        categoryList.add(new Category("Bakcell" , R.drawable.bakcell));
        categoryList.add(new Category("Nar Mobile" , R.drawable.nar));
        categoryList.add(new Category("NaxtelG " , R.drawable.naxtel));


        MobileOperatorRecyclerAdapter mobileOperatorRecyclerAdapter = new MobileOperatorRecyclerAdapter(categoryList);

        recyclerView = findViewById(R.id.recyclerViewMobile);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(mobileOperatorRecyclerAdapter);




    }
}
