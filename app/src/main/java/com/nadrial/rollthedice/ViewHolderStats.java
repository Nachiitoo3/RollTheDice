package com.nadrial.rollthedice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderStats extends RecyclerView.ViewHolder{
     TextView name, stat;
     ImageView img;
    public ViewHolderStats(@NonNull View itemView){
        super(itemView);

        name = itemView.findViewById(R.id.textViewStatItem);
        stat = itemView.findViewById(R.id.intItemStat);
        img = itemView.findViewById(R.id.imageStatsItem);
    }
}
