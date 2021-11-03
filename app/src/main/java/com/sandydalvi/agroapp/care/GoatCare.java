package com.sandydalvi.agroapp.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.care.buffcare.Activity10;
import com.sandydalvi.agroapp.care.buffcare.Activity11;
import com.sandydalvi.agroapp.care.buffcare.Activity12;
import com.sandydalvi.agroapp.care.gocare.Activity13;
import com.sandydalvi.agroapp.care.gocare.Activity14;
import com.sandydalvi.agroapp.care.gocare.Activity15;
import com.sandydalvi.agroapp.care.gocare.Activity16;

public class GoatCare extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goat_care);

        btn1=findViewById(R.id.gobtn1);
        btn2=findViewById(R.id.gobtn2);
        btn3=findViewById(R.id.gobtn3);
        btn4=findViewById(R.id.gobtn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GoatCare.this, Activity13.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GoatCare.this, Activity14.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GoatCare.this, Activity15.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GoatCare.this, Activity16.class);
                startActivity(intent);
            }
        });


    }
}