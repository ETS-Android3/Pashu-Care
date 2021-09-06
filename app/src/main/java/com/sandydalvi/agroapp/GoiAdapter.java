package com.sandydalvi.agroapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class GoiAdapter extends RecyclerView.Adapter<GoiAdapter.GoiViewHolder>
{
    LayoutInflater layoutInflater;
    List<GoiDetail> goidetail;

    public GoiAdapter(Context context,List<GoiDetail> goidetail)
    {
        this.layoutInflater= LayoutInflater.from(context);
        this.goidetail=goidetail;
    }

    @NonNull
    @Override
    public GoiAdapter.GoiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.goiitem,parent,false);

        return new GoiViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull GoiAdapter.GoiViewHolder holder, int position) {
        holder.itemName.setText(goidetail.get(position).getGroceryName());
        holder.itemPlace.setText(goidetail.get(position).getGroceryPlace());
        holder.itemPrice.setText("₹"+goidetail.get(position).getGroceryPrice());

//        Calendar cal=Calendar.getInstance(Locale.getDefault());
//        cal.setTimeInMillis(goidetail.get(position).getGroceryTime()*1000);
//        String date = DateFormat.format("dd//MM/yyyy",cal).toString();
        //holder.itemDate.setText(goidetail.get(position).getGroceryTime());
    }

    @Override
    public int getItemCount() {
        return goidetail.size();
    }

    public static class GoiViewHolder extends RecyclerView.ViewHolder{

        TextView itemPrice,itemPlace,itemName,itemDate;

        public GoiViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName=itemView.findViewById(R.id.ItemNameView);
            itemPlace=itemView.findViewById(R.id.ItemPlace);
            itemPrice=itemView.findViewById(R.id.ItemPrice);
            //itemDate=itemView.findViewById(R.id.ItemDate);
        }
    }
}
