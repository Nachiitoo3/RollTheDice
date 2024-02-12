package com.nadrial.rollthedice;

import android.widget.ImageView;

public class ItemAchievement {
    private Boolean completed;
    private String nameAchievement;

    public ImageView getImgAchivement() {
        return imgAchivement;
    }

    public void setImgAchivement(ImageView imgAchivement) {
        this.imgAchivement = imgAchivement;
    }

    private ImageView imgAchivement;


    public ItemAchievement(String nameAchievement, Boolean completed) {
        this.nameAchievement = nameAchievement;
        this.completed = completed;
    }


    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getNameAchievement() {
        return nameAchievement;
    }

    public void setNameAchievement(String nameAchievement) {
        this.nameAchievement = nameAchievement;
    }
}

