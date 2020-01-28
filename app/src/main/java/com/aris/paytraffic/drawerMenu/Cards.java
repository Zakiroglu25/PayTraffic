package com.aris.paytraffic.drawerMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aris.paytraffic.R;
import com.aris.paytraffic.drawerMenu.addItem.AddNewItem;
import com.aris.paytraffic.drawerMenu.addItem.RVAdapter;
import com.aris.paytraffic.drawerMenu.model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Cards extends AppCompatActivity implements RVAdapter.RecyclerViewOnClickListener {

    private static final int REQUEST = 1001;
    private List<Item> items = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private RecyclerView mRecyclerView;
    private RVAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int location;
    private Item model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        Toolbar myChildToolbar =
                findViewById(R.id.toolbar);
        setSupportActionBar(myChildToolbar);

        // Get a support ActionBar corresponding to this toolbar
        myChildToolbar.setNavigationOnClickListener(view -> onBackPressed());
        floatingActionButton = (FloatingActionButton)findViewById(R.id.fab);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        floatingActionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //StartActivityForResult
                        Intent intent = new Intent(Cards.this, AddNewItem.class);
                        intent.putExtra("isEditing", true);
                        startActivityForResult(intent, REQUEST);

                    }
                }
        );

        mAdapter = new RVAdapter(items);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setMyRecyclerViewOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST == requestCode) {
            if (data == null){
                return;
            }
            model = data.getParcelableExtra("message");
            if (resultCode == RESULT_FIRST_USER){
                items.add(model);
            }else if (resultCode == RESULT_OK){
                items.set(location, model);
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClickListener(View view, int position) {
        location = position;
        Item itemModel = new Item(items.get(position).getName(), items.get(position).getCard());
        Intent intent = new Intent(Cards.this, AddNewItem.class);
        intent.putExtra("isEditing", false);
        intent.putExtra("message", itemModel);
        startActivityForResult(intent, REQUEST);
    }
    }

