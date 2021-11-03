package com.sandydalvi.agroapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sandydalvi.agroapp.Types.TypesActivity;
import com.sandydalvi.agroapp.care.AnimalCare;
import com.sandydalvi.agroapp.trading.SearchActivity;
import com.sandydalvi.agroapp.trading.account.LoginActivity;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout lay1,lay2,lay3,lay4,lay5,lay6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lay1=findViewById(R.id.lay1);
        lay2=findViewById(R.id.lay2);
        lay3=findViewById(R.id.lay3);
        lay4=findViewById(R.id.lay4);
        lay5=findViewById(R.id.lay5);
        lay6=findViewById(R.id.lay6);

        lay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, TypesActivity.class);
                startActivity(intent);
            }
        });

        lay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AnimalCare.class);
                startActivity(intent);
            }
        });

//        lay3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,CommodityActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        lay4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,CommodityActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        lay5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this, WeatherActivity.class);
//                startActivity(intent);
//            }
//        });
//
        lay6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

    }

}