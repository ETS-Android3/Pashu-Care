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
import com.sandydalvi.agroapp.care.catcare.Activity1;
import com.sandydalvi.agroapp.care.catcare.Activity2;
import com.sandydalvi.agroapp.care.catcare.Activity3;
import com.sandydalvi.agroapp.care.catcare.Activity4;

public class BuffaloCare extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffalo_care);

        btn1=findViewById(R.id.bufbtn1);
        btn2=findViewById(R.id.bufbtn2);
        btn3=findViewById(R.id.bufbtn3);
        btn4=findViewById(R.id.bufbtn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuffaloCare.this, com.sandydalvi.agroapp.care.buffcare.Activity1.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuffaloCare.this, Activity10.class);
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuffaloCare.this, Activity11.class);
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BuffaloCare.this, Activity12.class);
                startActivity(intent);
            }
        });



    }
}