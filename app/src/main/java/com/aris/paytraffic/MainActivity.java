package com.aris.paytraffic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.aris.paytraffic.drawerMenu.BonuceActivity;
import com.aris.paytraffic.drawerMenu.ConvertToBounce;
import com.aris.paytraffic.drawerMenu.InfoActivity;
import com.aris.paytraffic.drawerMenu.InviteActivity;
import com.aris.paytraffic.drawerMenu.PaymentsActivity;
import com.aris.paytraffic.drawerMenu.TransfersActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();

        //  DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

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
}
