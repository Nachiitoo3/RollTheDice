package com.nadrial.rollthedice;

import android.widget.ImageView;

public class ItemStat {
    private String nameStats;
    private String stat;

    public ImageView getImgStats() {
        return imgStats;
    }

    public void setImgAchivement(ImageView imgStats) {
        this.imgStats = imgStats;
    }

    private ImageView imgStats;

    public ItemStat(String name, String stat) {
        this.nameStats = name;
        this.stat = stat;
    }


    public String getNameStats() {
        return nameStats;
    }

    public void setNameStats(String nameStats) {
        this.nameStats = nameStats;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}

