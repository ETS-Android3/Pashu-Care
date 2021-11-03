package com.sandydalvi.agroapp.trading;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.Types.TypesActivity;
import com.sandydalvi.agroapp.trading.util.SectionsPagerAdapter;

import java.util.Objects;

public class SearchActivity extends AppCompatActivity {

    protected TabLayout mTabLayout;
    public ViewPager mViewPager;
    public AppCompatButton understand;

    public SectionsPagerAdapter mPagerAdapter;

    ConstraintLayout sellay,buylay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        understand=findViewById(R.id.understand);
        sellay=findViewById(R.id.selllay);
        buylay=findViewById(R.id.buylay);

        understand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this, TypesActivity.class);
                startActivity(intent);
            }
        });

        sellay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this,SellActivity.class);
                startActivity(intent);
            }
        });

        buylay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this,BuyActivity.class);
                startActivity(intent);
            }
        });

//        mTabLayout= (TabLayout) findViewById(R.id.tabs);
//        mViewPager=(ViewPager) findViewById(R.id.viewpager_container);
//
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//        verifyPermissions();
//        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                mViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//
//        });
    }
    private void setupViewPager()
    {
        mPagerAdapter=new SectionsPagerAdapter(getSupportFragmentManager());
        //mPagerAdapter= new SectionsPagerAdapter(getChildFragmentManager());
        mPagerAdapter.addFragment(new com.sandydalvi.agroapp.trading.SearchFragment());
        mPagerAdapter.addFragment(new com.sandydalvi.agroapp.trading.WatchListFragment());
        mPagerAdapter.addFragment(new com.sandydalvi.agroapp.trading.PostFragment());
        mPagerAdapter.addFragment(new com.sandydalvi.agroapp.trading.AccountFragment());

        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setText(getString(R.string.fragment_search));
        mTabLayout.getTabAt(1).setText(getString(R.string.fragment_watch_list));
        mTabLayout.getTabAt(2).setText(getString(R.string.fragment_post));
        mTabLayout.getTabAt(3).setText(getString(R.string.fragment_account));


    }

    private void verifyPermissions()
    {
        String[] permisssions={Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permisssions[0])== PackageManager.PERMISSION_GRANTED
                 && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permisssions[1])== PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permisssions[2])== PackageManager.PERMISSION_GRANTED)
        {
            setupViewPager();
        }
        else
        {
            ActivityCompat.requestPermissions(SearchActivity.this,
                    permisssions,
                    1);
        }
    }

}