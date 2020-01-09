package com.aris.paytraffic;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import com.aris.paytraffic.drawerMenu.BonuceActivity;
import com.aris.paytraffic.drawerMenu.ConvertToBounce;
import com.aris.paytraffic.drawerMenu.InfoActivity;
import com.aris.paytraffic.drawerMenu.InviteActivity;
import com.aris.paytraffic.drawerMenu.PaymentsActivity;
import com.aris.paytraffic.drawerMenu.TransfersActivity;
import com.aris.paytraffic.viewPager.CardItem;
import com.aris.paytraffic.viewPager.CardPagerAdapter;
import com.aris.paytraffic.viewPager.ShadowTransformer;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    ViewPager viewPager;
    private ShadowTransformer mCardShadowTransformer;
    CardPagerAdapter mCardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
//
//
//        viewPager.setAdapter(viewPagerAdapter);
//
//
//
//
//        dotscount = viewPagerAdapter.getCount();
//        dots = new ImageView[dotscount];
//
//        for(int i = 0; i < dotscount; i++){
//
//            dots[i] = new ImageView(this);
//            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
//
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//            params.getLayoutDirection();
//            params.setMarginStart(50);
//            //params.setMargins(8, 0, 8, 0);
//
//          //  sliderDotspanel.addView(dots[i], params);
//
//        }
//
//        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//                for(int i = 0; i< dotscount; i++){
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
//                }
//
//                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();


        viewPager =findViewById(R.id.viewPager);
        mCardAdapter = new CardPagerAdapter();
        mCardAdapter .addCardItem(new CardItem(R.id.categoryImageView,R.id.categoryName));
        mCardAdapter .addCardItem(new CardItem(R.id.categoryImageView,R.id.categoryName));
        mCardAdapter .addCardItem(new CardItem(R.id.categoryImageView,R.id.categoryName));
        mCardAdapter .addCardItem(new CardItem(R.id.categoryImageView,R.id.categoryName));
        mCardAdapter .addCardItem(new CardItem(R.id.categoryImageView,R.id.categoryName));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1));
//        mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1));


        mCardShadowTransformer = new ShadowTransformer(viewPager, mCardAdapter);
        // mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        viewPager.setAdapter(mCardAdapter);
        viewPager.setPageTransformer(false, mCardShadowTransformer);
        viewPager.setOffscreenPageLimit(3);

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

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
