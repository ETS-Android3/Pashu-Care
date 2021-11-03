package com.sandydalvi.agroapp.Types;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sandydalvi.agroapp.R;

import java.util.ArrayList;

public class AdapteCategories extends RecyclerView.Adapter<AdapteCategories.ViewHolder> {

    private ArrayList<Categories> categories;
    private Context context;

    public AdapteCategories(ArrayList<Categories> categories,Context context)
    {
        this.categories=categories;
        this.context=context;
    }

    @NonNull
    @Override
    public AdapteCategories.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.types_category_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapteCategories.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final Categories cat=categories.get(position);
        holder.titleTextView.setText(cat.getTitle());
        holder.imageView.setImageResource(cat.getImageResource());

        holder.titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ShowActivity.class);
                intent.putExtra("catname",cat.getTitle());
                context.startActivity(intent);
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ShowActivity.class);
                intent.putExtra("catname",cat.getTitle());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView1);
            titleTextView=itemView.findViewById(R.id.titleTextView1);
        }
    }
}


//public class AdapteCategories extends RecyclerView.Adapter<AdapteCategories.ViewHolder> {
//
//    private ArrayList<Categories> categories;
//    private Context context;
//
//    public AdapteCategories(ArrayList<Categories> categories, Context context) {
//        this.categories = categories;
//        this.context = context;
//    }
//
//    @NonNull
//    @Override
//    public AdapteCategories.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.types_category_item,parent,false);
//        return new ViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AdapteCategories.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return categories.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder
//    {
//
//        ImageView imageView;
//        TextView textView;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imageView=itemView.findViewById(R.id.imageView1);
//            textView=itemView.findViewById(R.id.titleTextView1);
//        }
//    }
//}
