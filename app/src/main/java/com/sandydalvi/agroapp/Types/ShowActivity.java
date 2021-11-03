package com.sandydalvi.agroapp.Types;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.sandydalvi.agroapp.R;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    private ArrayList<Item> items_list=new ArrayList<>();
    private  ArrayList<Item> item_cow=new ArrayList<>();
    private  ArrayList<Item> item_hens=new ArrayList<>();
    private  ArrayList<Item> item_goat=new ArrayList<>();
    private  ArrayList<Item> item_buff =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //cows data
        item_cow.add(new Item(R.drawable.cow_1,getString(R.string.cow_1_tit),getString(R.string.cow_1_desc)));
        item_cow.add(new Item(R.drawable.cow_2,getString(R.string.cow_2_tit),getString(R.string.cow_2_desc)));
        item_cow.add(new Item(R.drawable.cow_3,getString(R.string.cow_3_tit),getString(R.string.cow_3_desc)));
        item_cow.add(new Item(R.drawable.cow_4,getString(R.string.cow_4_tit),getString(R.string.cow_4_desc)));
        item_cow.add(new Item(R.drawable.cow_5,getString(R.string.cow_5_tit),getString(R.string.cow_5_desc)));
        item_cow.add(new Item(R.drawable.cow_6,getString(R.string.cow_6_tit),getString(R.string.cow_6_desc)));
        item_cow.add(new Item(R.drawable.cow_7,getString(R.string.cow_7_tit),getString(R.string.cow_7_desc)));
        item_cow.add(new Item(R.drawable.cow_8,getString(R.string.cow_8_tit),getString(R.string.cow_8_desc)));
        item_cow.add(new Item(R.drawable.cow_9,getString(R.string.cow_9_tit),getString(R.string.cow_9_desc)));
        item_cow.add(new Item(R.drawable.cow_10,getString(R.string.cow_10_tit),getString(R.string.cow_10_desc)));
        item_cow.add(new Item(R.drawable.cow_11,getString(R.string.cow_11_tit),getString(R.string.cow_11_desc)));
        item_cow.add(new Item(R.drawable.cow_12,getString(R.string.cow_12_tit),getString(R.string.cow_12_desc)));
        item_cow.add(new Item(R.drawable.cow_13,getString(R.string.cow_13_tit),getString(R.string.cow_13_desc)));
        item_cow.add(new Item(R.drawable.cow_14,getString(R.string.cow_14_tit),getString(R.string.cow_14_desc)));
        item_cow.add(new Item(R.drawable.cow_15,getString(R.string.cow_15_tit),getString(R.string.cow_15_desc)));
        item_cow.add(new Item(R.drawable.cow_16,getString(R.string.cow_16_tit),getString(R.string.cow_16_desc)));
        item_cow.add(new Item(R.drawable.cow_17,getString(R.string.cow_17_tit),getString(R.string.cow_17_desc)));
        item_cow.add(new Item(R.drawable.cow_18,getString(R.string.cow_18_tit),getString(R.string.cow_18_desc)));
        item_cow.add(new Item(R.drawable.cow_19,getString(R.string.cow_19_tit),getString(R.string.cow_19_desc)));
        item_cow.add(new Item(R.drawable.cow_20,getString(R.string.cow_20_tit),getString(R.string.cow_20_desc)));
        item_cow.add(new Item(R.drawable.cow_21,getString(R.string.cow_21_tit),getString(R.string.cow_21_desc)));
        item_cow.add(new Item(R.drawable.cow_22,getString(R.string.cow_22_tit),getString(R.string.cow_22_desc)));


        //hens data
        item_hens.add(new Item(R.drawable.hen_1,getString(R.string.hen_1_tit),getString(R.string.hen_1_desc)));
        item_hens.add(new Item(R.drawable.hen_2,getString(R.string.hen_2_tit),getString(R.string.hen_2_desc)));
        item_hens.add(new Item(R.drawable.hen_3,getString(R.string.hen_3_tit),getString(R.string.hen_3_desc)));
        item_hens.add(new Item(R.drawable.hen_4,getString(R.string.hen_4_tit),getString(R.string.hen_4_desc)));
        item_hens.add(new Item(R.drawable.hen_5,getString(R.string.hen_5_tit),getString(R.string.hen_5_desc)));
        item_hens.add(new Item(R.drawable.hen_6,getString(R.string.hen_6_tit),getString(R.string.hen_6_desc)));
        item_hens.add(new Item(R.drawable.hen_7,getString(R.string.hen_7_tit),getString(R.string.hen_7_desc)));
        item_hens.add(new Item(R.drawable.hen_8,getString(R.string.hen_8_tit),getString(R.string.hen_8_desc)));
        item_hens.add(new Item(R.drawable.hen_9,getString(R.string.hen_9_tit),getString(R.string.hen_9_desc)));
        item_hens.add(new Item(R.drawable.hen_10,getString(R.string.hen_10_tit),getString(R.string.hen_10_desc)));
        item_hens.add(new Item(R.drawable.hen_11,getString(R.string.hen_11_tit),getString(R.string.hen_11_desc)));
        item_hens.add(new Item(R.drawable.hen_12,getString(R.string.hen_12_tit),getString(R.string.hen_12_desc)));
        item_hens.add(new Item(R.drawable.hen_13,getString(R.string.hen_13_tit),getString(R.string.hen_13_desc)));
        item_hens.add(new Item(R.drawable.hen_14,getString(R.string.hen_14_tit),getString(R.string.hen_14_desc)));
        item_hens.add(new Item(R.drawable.hen_15,getString(R.string.hen_15_tit),getString(R.string.hen_15_desc)));
        item_hens.add(new Item(R.drawable.hen_16,getString(R.string.hen_16_tit),getString(R.string.hen_16_desc)));
        item_hens.add(new Item(R.drawable.hen_17,getString(R.string.hen_17_tit),getString(R.string.hen_17_desc)));
        item_hens.add(new Item(R.drawable.hen_18,getString(R.string.hen_18_tit),getString(R.string.hen_18_desc)));
        item_hens.add(new Item(R.drawable.hen_19,getString(R.string.hen_19_tit),getString(R.string.hen_19_desc)));

        item_buff.add(new Item(R.drawable.buff_1,getString(R.string.buf_1_tit),getString(R.string.buf_1_desc)));
        item_buff.add(new Item(R.drawable.buff_2,getString(R.string.buf_2_tit),getString(R.string.buf_2_desc)));
        item_buff.add(new Item(R.drawable.buff_3,getString(R.string.buf_3_tit),getString(R.string.buf_3_desc)));
        item_buff.add(new Item(R.drawable.buff_4,getString(R.string.buf_4_tit),getString(R.string.buf_4_desc)));
        item_buff.add(new Item(R.drawable.buff_5,getString(R.string.buf_5_tit),getString(R.string.buf_5_desc)));
        item_buff.add(new Item(R.drawable.buff_6,getString(R.string.buf_6_tit),getString(R.string.buf_6_desc)));
        item_buff.add(new Item(R.drawable.buff_7,getString(R.string.buf_7_tit),getString(R.string.buf_7_desc)));
        item_buff.add(new Item(R.drawable.buff_8,getString(R.string.buf_8_tit),getString(R.string.buf_8_desc)));
        item_buff.add(new Item(R.drawable.buff_9,getString(R.string.buf_9_tit),getString(R.string.buf_9_desc)));
        item_buff.add(new Item(R.drawable.buff_11,getString(R.string.buf_10_tit),getString(R.string.buf_10_desc)));

        item_goat.add(new Item(R.drawable.goat_1,getString(R.string.goat_1_tit),getString(R.string.goat_1_desc)));
        item_goat.add(new Item(R.drawable.goat_2,getString(R.string.goat_2_tit),getString(R.string.goat_2_desc)));
        item_goat.add(new Item(R.drawable.goat_3,getString(R.string.goat_3_tit),getString(R.string.goat_3_desc)));
        item_goat.add(new Item(R.drawable.goat_4,getString(R.string.goat_4_tit),getString(R.string.goat_4_desc)));
        item_goat.add(new Item(R.drawable.goat_5,getString(R.string.goat_5_tit),getString(R.string.goat_5_desc)));
        item_goat.add(new Item(R.drawable.goat_6,getString(R.string.goat_6_tit),getString(R.string.goat_6_desc)));
        item_goat.add(new Item(R.drawable.goat_7,getString(R.string.goat_7_tit),getString(R.string.goat_7_desc)));
        item_goat.add(new Item(R.drawable.goat_8,getString(R.string.goat_8_tit),getString(R.string.goat_8_desc)));
        item_goat.add(new Item(R.drawable.goat_9,getString(R.string.goat_9_tit),getString(R.string.goat_9_desc)));
        item_goat.add(new Item(R.drawable.goat_10,getString(R.string.goat_10_tit),getString(R.string.goat_10_desc)));



        String activity=getIntent().getStringExtra("catname");
        if(activity.equals("Cattle"))
        {
            recyclerView.setAdapter(new Adapter(item_cow,this));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else if(activity.equals("Hens"))
        {
            recyclerView.setAdapter(new Adapter(item_hens,this));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else if(activity.equals("Buffalo"))
        {
            recyclerView.setAdapter(new Adapter(item_buff,this));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        else if(activity.equals("Goat"))
        {
            recyclerView.setAdapter(new Adapter(item_goat,this));
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

    }
}