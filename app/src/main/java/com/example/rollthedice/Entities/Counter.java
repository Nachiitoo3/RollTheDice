package com.example.rollthedice.Entities;


public class Counter {

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void increment() {
        count++;
    }

    public static void reset() {
        count = 0;
    }
}
