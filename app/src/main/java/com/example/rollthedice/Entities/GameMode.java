package com.example.rollthedice.Entities;

public class GameMode {

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public static long duration = 20000;

    public static int categoria, indexSpinner;


}
