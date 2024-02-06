package com.nadrial.rollthedice.Entities;

public class GameMode {


    public static long getDuration() {
        return duration;
    }

    public static void setDuration(long newDuration) {
        duration = newDuration;
    }

    public static int getCategoria() {
        return categoria;
    }

    public static void setCategoria(int newCategoria) {
        categoria = newCategoria;
    }

    public static long duration = 20000;

    public static int categoria = -2;

    public static int getIndexSpinner() {
        return indexSpinner;
    }

    public static void setIndexSpinner(int newIndexSpinner) {
        indexSpinner = newIndexSpinner;
    }

    public static int indexSpinner;


}
