package com.sandydalvi.agroapp.trading;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sandydalvi.agroapp.R;
import com.sandydalvi.agroapp.trading.models.Post;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final Context context;

    private final ArrayList<Post> list;

    public MyAdapter(Context context, ArrayList<Post> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Post post = list.get(position);

        holder.name.setText(post.getTitle());
        holder.mobile.setText(post.getContact_email());
        String pri=post.getPrice();
        pri=pri.concat("/-");
        holder.price.setText(pri);
        //Picasso.get().load(post.getImage()).into(holder.image);
        Glide.with(context)
                .load(post.getImage())
                .into(holder.image);

        holder.buybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,ViewPostActivity.class);
                intent.putExtra("name",post.getTitle());
                intent.putExtra("email",post.getContact_email());
                intent.putExtra("price",post.getPrice());
                intent.putExtra("country",post.getCountry());
                intent.putExtra("state",post.getState_provience());
                intent.putExtra("city",post.getCity());
                intent.putExtra("img",post.getImage());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,mobile,price;
        ImageView image;
        AppCompatButton buybtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.animname);
            mobile = itemView.findViewById(R.id.animcontact);
            price = itemView.findViewById(R.id.animprice);
            buybtn = itemView.findViewById(R.id.buybtn);
            image=itemView.findViewById(R.id.aniimg);

        }
    }

}