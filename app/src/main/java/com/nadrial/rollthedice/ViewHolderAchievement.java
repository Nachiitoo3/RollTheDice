package com.nadrial.rollthedice;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderAchievement extends RecyclerView.ViewHolder{
     TextView name;

     ImageView img;
    public ViewHolderAchievement(@NonNull View itemView){
        super(itemView);

        name = itemView.findViewById(R.id.textViewStatItem);
        img = itemView.findViewById(R.id.imageStatsItem);
    }
}
