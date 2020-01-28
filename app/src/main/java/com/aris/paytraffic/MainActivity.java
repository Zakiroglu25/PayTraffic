package com.aris.paytraffic;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.aris.paytraffic.activiy.ProfilActivity;
import com.aris.paytraffic.activiy.SearchActivity;
import com.aris.paytraffic.drawerMenu.Cards;
import com.aris.paytraffic.drawerMenu.ContactActivity;
import com.aris.paytraffic.drawerMenu.ConvertToBounce;
import com.aris.paytraffic.drawerMenu.InfoActivity;
import com.aris.paytraffic.drawerMenu.InviteActivity;
import com.aris.paytraffic.drawerMenu.OfferActivity;
import com.aris.paytraffic.drawerMenu.TransfersActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    ConstraintLayout constayner;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }
    private void initViews() {

        drawerLayout = findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(drawerToggle);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();

         navController = Navigation.findNavController(this, R.id.nav_host_fragment);
       NavigationUI.setupWithNavController(bottomNavigationView, navController);


        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headView = navigationView.getHeaderView(0);
        ImageView imageProfil = headView.findViewById(R.id.profile_img);
        imageProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;


        drawerLayout.closeDrawer(GravityCompat.START    );
        switch (menuItem.getItemId()) {

            case R.id.nav_teklif:
                startActivity(new Intent(this, OfferActivity.class));
                break;
            case R.id.nav_kocurmeler:
                startActivity(new Intent(this, TransfersActivity.class));
                break;
            case R.id.nav_bonuslar:
                navController.navigate(R.id.navigation_bounces);
//                navController.navigate(item.getItemId(), null, options);
//                startActivity(new Intent(this, BonuceActivity.class));
                break;
            case R.id.nav_odemeler:
               navController.navigate(R.id.navigation_payments);
                break;
            case R.id.nav_kartlar:
                startActivity(new Intent(this, Cards.class));
                break;
            case R.id.nav_elaqe:
                startActivity(new Intent(this, ContactActivity.class));
                break;
            case R.id.nav_bonuslara_cevir:
                startActivity(new Intent(this, ConvertToBounce.class));
                break;
            case R.id.nav_devetet:
                startActivity(new Intent(this, InviteActivity.class));
                break;
            case R.id.nav_melumat:
                startActivity(new Intent(this, InfoActivity.class));
            default:
                Toast.makeText(this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //  getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void toolbarClick(View view) {
        switch (view.getId()) {
            case R.id.imageView3:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.search:
                startActivity(new Intent(this, SearchActivity.class));
        }
    }

    @Override
    public void onClick(View v) {

    }
}
