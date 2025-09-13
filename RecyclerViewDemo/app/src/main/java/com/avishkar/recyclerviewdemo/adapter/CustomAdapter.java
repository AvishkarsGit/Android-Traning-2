package com.avishkar.recyclerviewdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.avishkar.recyclerviewdemo.R;
import com.avishkar.recyclerviewdemo.holder.MyViewHolder;
import com.avishkar.recyclerviewdemo.model.ItemsModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context context;
    ArrayList<ItemsModel> itemsList;

    public CustomAdapter(Context context, ArrayList<ItemsModel> itemsList) {
        this.context = context;
        this.itemsList = itemsList; //list of items model type
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_row_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int index) {
        ItemsModel model = itemsList.get(index);
        holder.image.setImageResource(model.getImage());
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());
        holder.price.setText(model.getPrice() + ".00");
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}


