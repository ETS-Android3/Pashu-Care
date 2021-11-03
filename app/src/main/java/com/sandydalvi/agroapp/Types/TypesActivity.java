package com.sandydalvi.agroapp.Types;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sandydalvi.agroapp.R;

import java.util.ArrayList;

public class TypesActivity extends AppCompatActivity {

    private  ArrayList<Categories> categories=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView=findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new AdapteCategories(categories,this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categories.add(new Categories(R.drawable.cow_1,"Cattle"));
        categories.add(new Categories(R.drawable.hen_1,"Hens"));
        categories.add(new Categories(R.drawable.buf_1,"Buffalo"));
        categories.add(new Categories(R.drawable.goat_1,"Goat"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}