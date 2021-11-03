package com.sandydalvi.agroapp.care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.care.catcare.Activity1;
import com.sandydalvi.agroapp.care.catcare.Activity2;
import com.sandydalvi.agroapp.care.catcare.Activity3;
import com.sandydalvi.agroapp.care.catcare.Activity4;
import com.sandydalvi.agroapp.care.catcare.Activity5;
import com.sandydalvi.agroapp.care.catcare.Activity6;
import com.sandydalvi.agroapp.care.catcare.Activity7;
import com.sandydalvi.agroapp.care.catcare.Activity8;

public class CattleCare extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cattle_care);

        btn1=findViewById(R.id.catexp1);
        btn2=findViewById(R.id.catexp2);
        btn3=findViewById(R.id.catexp3);
        btn4=findViewById(R.id.catexp4);
        btn5=findViewById(R.id.catexp5);
        btn6=findViewById(R.id.catexp6);
        btn7=findViewById(R.id.catexp7);
        btn8=findViewById(R.id.catexp8);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CattleCare.this, Activity1.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CattleCare.this, Activity2.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CattleCare.this, Activity3.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CattleCare.this, Activity4.class);
                startActivity(intent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CattleCare.this, Activity5.class);
                startActivity(intent);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CattleCare.this, Activity6.class);
                startActivity(intent);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CattleCare.this, Activity7.class);
                startActivity(intent);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CattleCare.this, Activity8.class);
                startActivity(intent);
            }
        });



    }
}