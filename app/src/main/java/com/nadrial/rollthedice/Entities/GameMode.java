package com.nadrial.rollthedice.Entities;

public class GameMode {

    public static long duration = 20000;

    public static int category = -2, mode = 0;

    public static long getDuration() {
        return duration;
    }

    public static void setDuration(long newDuration) {
        duration = newDuration;
    }

    public static int getCategory() {
        return category;
    }

    public static void setCategory(int newCategoria) {
        category = newCategoria;
    }



    public static int getMode() {
        return mode;
    }

    public static void setMode(int newMode) {
        mode = newMode;
    }






}
