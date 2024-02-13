package com.nadrial.rollthedice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ItemAdapterAchievement extends RecyclerView.Adapter<ViewHolderAchievement>{

    Context context;
    List<ItemAchievement> itemsAchievement;


    public ItemAdapterAchievement(Context context, List<ItemAchievement> items) {
        this.context = context;
        this.itemsAchievement = items;

    }

    @NonNull
    @Override
    public ViewHolderAchievement onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAchievement(LayoutInflater.from(context).inflate(R.layout.achievementitemview,parent,false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolderAchievement holder, int position) {
        Glide.with(context)
                .load(R.drawable.trofeo)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);
        holder.name.setText(itemsAchievement.get(position).getNameAchievement());
        if(!itemsAchievement.get(position).getCompleted()){
            Glide.with(context)
                    .load(R.drawable.trofeogris)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
            holder.name.setText(itemsAchievement.get(position).getNameAchievement());
        }


    }

        @Override
    public int getItemCount() {
        return itemsAchievement.size();
    }


}
