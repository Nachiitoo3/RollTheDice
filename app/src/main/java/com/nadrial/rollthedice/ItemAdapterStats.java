package com.nadrial.rollthedice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ItemAdapterStats extends RecyclerView.Adapter<ViewHolderStats>{

    Context context;
    List<ItemStat> itemStats;


    public ItemAdapterStats(Context context, List<ItemStat> items) {
        this.context = context;
        this.itemStats = items;

    }

    @NonNull
    @Override
    public ViewHolderStats onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderStats(LayoutInflater.from(context).inflate(R.layout.statsitemview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStats holder, int position) {
        Glide.with(context)
                .load(R.drawable.statsimage)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);
        holder.name.setText(itemStats.get(position).getNameStats());
        holder.stat.setText(itemStats.get(position).getStat());
    }

        @Override
    public int getItemCount() {
        return itemStats.size();
    }


}
