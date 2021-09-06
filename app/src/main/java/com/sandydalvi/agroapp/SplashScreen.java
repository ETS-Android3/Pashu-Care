package com.sandydalvi.agroapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.sandydalvi.agroapp.fragments.OnBoardingFragment1;
import com.sandydalvi.agroapp.fragments.OnBoardingFragment2;
import com.sandydalvi.agroapp.fragments.OnBoardingFragment3;

public class SplashScreen extends AppCompatActivity {


    ImageView logo,img;
    TextView app_name,app_name1;
    LottieAnimationView lottieAnimationView;
    Animation topAnim,bottomAnim,anim;

    private static int SPLASH_TIME_OUT= 6000;
    SharedPreferences mSharedPreferences;

    private static final int NUM_PAGE=3;
    private ViewPager viewPager;
    private ScreenSlidePagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logo=(ImageView)findViewById(R.id.logo);
        img=(ImageView)findViewById(R.id.img);
        app_name=(TextView)findViewById(R.id.app_name);
        app_name1=(TextView)findViewById(R.id.app_name_disc);
        lottieAnimationView=findViewById(R.id.lottie);

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        logo.setAnimation(topAnim);
        app_name.setAnimation(bottomAnim);
        app_name1.setAnimation(bottomAnim);

        viewPager=(ViewPager)findViewById(R.id.pager);
        adapter=new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        anim=AnimationUtils.loadAnimation(this,R.anim.a_b_anim);
        viewPager.startAnimation(anim);

        img.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        app_name.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        app_name1.animate().translationY(1400).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                mSharedPreferences=getSharedPreferences("SharedPref",MODE_PRIVATE);
//                boolean isFirstTime=mSharedPreferences.getBoolean("firstTime",true);
//
//                if(isFirstTime)
//                {
//                    SharedPreferences.Editor editor=mSharedPreferences.edit();
//                    editor.putBoolean("firstTime",false);
//                    editor.apply();
//                }
//                else
//                {
//                    startActivity(new Intent(SplashScreen.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
//                    finish();
//                }

            }
        },SPLASH_TIME_OUT);

    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter
    {

        public ScreenSlidePagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0:
                    OnBoardingFragment1 tab1=new OnBoardingFragment1();
                    return tab1;
                case 1:
                    OnBoardingFragment2 tab2=new OnBoardingFragment2();
                    return tab2;
                case 2:
                    OnBoardingFragment3 tab3=new OnBoardingFragment3();
                    return tab3;
            }
            return null;
        }

        @Override
        public int getCount() {

            return NUM_PAGE;
        }
    }

    ////////////////////////////////////

//    ImageView imageView,back;
//    TextView textView,textView1;
//    LottieAnimationView lottieAnimationView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash_screen);
//
//        back=(ImageView)findViewById(R.id.img);
//        imageView=(ImageView)findViewById(R.id.logo);
//        textView=(TextView)findViewById(R.id.app_name);
//        textView1=(TextView)findViewById(R.id.app_name_disc);
//        lottieAnimationView=(LottieAnimationView)findViewById(R.id.lottie);
//
//        back.animate().translationY(-1600).setDuration(2000).setStartDelay(4000);
//        imageView.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
//        textView.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
//        textView1.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
//        lottieAnimationView.animate().translationY(1400).setDuration(2000).setStartDelay(4000);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashScreen.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//            }
//        },7000);
//
//    }
}