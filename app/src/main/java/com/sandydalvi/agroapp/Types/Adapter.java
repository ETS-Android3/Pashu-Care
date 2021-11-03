package com.sandydalvi.agroapp.Types;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sandydalvi.agroapp.R;

import java.util.ArrayList;

import ru.embersoft.expandabletextview.ExpandableTextView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Item> items;
    private Context context;

    public Adapter(ArrayList<Item> items,Context context)
    {
        this.items=items;
        this.context=context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.types_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final Item item=items.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.imageView.setImageResource(item.getImageResource());
        holder.descTextView.setText(item.getDesc());
        holder.descTextView.setOnStateChangeListener(new ExpandableTextView.OnStateChangeListener() {
            @Override
            public void onStateChange(boolean isShrink) {
                Item content=items.get(position);
                content.setShrink(isShrink);
            }
        });
        holder.descTextView.setText(item.getDesc());
        holder.descTextView.resetState(item.isShrink());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        ExpandableTextView descTextView;
        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            descTextView=itemView.findViewById(R.id.descTextView);
            titleTextView=itemView.findViewById(R.id.titleTextView);
        }
    }
}
