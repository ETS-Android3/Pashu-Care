package com.sandydalvi.agroapp.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.care.catcare.Activity1;
import com.sandydalvi.agroapp.care.hencare.Activity17;
import com.sandydalvi.agroapp.care.hencare.Activity18;
import com.sandydalvi.agroapp.care.hencare.Activity19;
import com.sandydalvi.agroapp.care.hencare.Activity20;
import com.sandydalvi.agroapp.care.hencare.Activity21;
import com.sandydalvi.agroapp.care.hencare.Activity22;
import com.sandydalvi.agroapp.care.hencare.Activity23;
import com.sandydalvi.agroapp.care.hencare.Activity24;

public class HensCare extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hens_care);

        btn1=findViewById(R.id.henbtn1);
        btn2=findViewById(R.id.henbtn2);
        btn3=findViewById(R.id.henbtn3);
        btn4=findViewById(R.id.henbtn4);
        btn5=findViewById(R.id.henbtn5);
        btn6=findViewById(R.id.henbtn6);
        btn7=findViewById(R.id.henbtn7);
        btn8=findViewById(R.id.henbtn8);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HensCare.this, Activity17.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HensCare.this, Activity18.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HensCare.this, Activity19.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HensCare.this, Activity20.class);
                startActivity(intent);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HensCare.this, Activity21.class);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HensCare.this, Activity22.class);
                startActivity(intent);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HensCare.this, Activity23.class);
                startActivity(intent);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HensCare.this, Activity24.class);
                startActivity(intent);
            }
        });


    }
}