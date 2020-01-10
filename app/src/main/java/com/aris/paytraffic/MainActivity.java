package com.aris.paytraffic;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.aris.paytraffic.drawerMenu.BonuceActivity;
import com.aris.paytraffic.drawerMenu.ConvertToBounce;
import com.aris.paytraffic.drawerMenu.InfoActivity;
import com.aris.paytraffic.drawerMenu.InviteActivity;
import com.aris.paytraffic.drawerMenu.PaymentsActivity;
import com.aris.paytraffic.drawerMenu.TransfersActivity;
import com.aris.paytraffic.viewPager.DensityUtil;
import com.aris.paytraffic.viewPager.ViewPagerAdpter;
import com.aris.paytraffic.viewPager.ZoomOutPagerTransformer;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    private ViewPager  banner_main_ZoomOut;

    int arrayImgs[] = {R.drawable.lebedun,
            R.drawable.lebedun,
            R.drawable.lebedun,
            R.drawable.lebedun,
            R.drawable.lebedun,
            R.drawable.lebedun};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
        NavigationView navigationView = findViewById(R.id.nav_view);
        banner_main_ZoomOut = (ViewPager) findViewById(R.id.banner_main_ZoomOut);
        banner_main_ZoomOut.setPageMargin(-DensityUtil.dip2px(getApplicationContext(), 10));
        banner_main_ZoomOut.setOffscreenPageLimit(3);
        banner_main_ZoomOut.setPageTransformer(false, (ViewPager.PageTransformer) new ZoomOutPagerTransformer(0.7f));
        banner_main_ZoomOut.setAdapter(new ViewPagerAdpter(getData()));
    }
    private List<ImageView> getData() {
        List<ImageView> imgList = new ArrayList<>();
        for (int i = 0; i < arrayImgs.length; i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(arrayImgs[i]);
            imgList.add(imageView);
        }
        return imgList;
    }

    private void initViews() {

        drawerLayout = findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();


        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_kocurmeler:
                startActivity(new Intent(this, TransfersActivity.class));
                break;
            case R.id.nav_bonuslar:
                startActivity(new Intent(this, BonuceActivity.class));
                break;
            case R.id.nav_odemeler:
                startActivity(new Intent(this, PaymentsActivity.class));
                break;
            case R.id.nav_elaqe:
                startActivity(new Intent(this, InfoActivity.class));
                break;
            case R.id.nav_bonuslara_cevir:
                startActivity(new Intent(this, ConvertToBounce.class));
                break;
            case R.id.nav_devetet:
                startActivity(new Intent(this, InviteActivity.class));
                break;
            default:
                Toast.makeText(this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void toolbarClick(View view) {
        switch (view.getId()) {
            case R.id.imageView3:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
