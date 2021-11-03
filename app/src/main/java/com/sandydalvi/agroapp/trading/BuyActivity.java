package com.sandydalvi.agroapp.trading;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.trading.models.Post;

import java.util.ArrayList;

public class BuyActivity extends AppCompatActivity {

    private static final String TAG = "BuyActivity";

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapter myAdapter;
    ArrayList<Post> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        recyclerView=findViewById(R.id.userList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(BuyActivity.this));
        list=new ArrayList<>();

        myAdapter=new MyAdapter(BuyActivity.this,list);
        recyclerView.setAdapter(myAdapter);

        database= FirebaseDatabase.getInstance().getReference("posts");

        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        Post user = ds.getValue(Post.class);
                        assert user != null;
                        Log.d(TAG,"email "+user.getContact_email()+" image "+user.getImage());
                        list.add(user);

                    }
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}