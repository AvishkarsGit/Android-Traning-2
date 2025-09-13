package com.avishkar.recyclerviewdemo.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avishkar.recyclerviewdemo.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public  ImageView image;
    public TextView title, description,price;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        image =  itemView.findViewById(R.id.itemImg);
        title = itemView.findViewById(R.id.itemTitle);
        description = itemView.findViewById(R.id.itemDesc);
        price = itemView.findViewById(R.id.itemPrice);

    }
}
