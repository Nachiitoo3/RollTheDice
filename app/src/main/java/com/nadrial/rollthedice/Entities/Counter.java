package com.nadrial.rollthedice.Entities;


public class Counter {

    private static int count = 0;



    private static int mitCount = 0;
    private static int natCount = 0;
    private static int foodCount = 0;
    private static int tripCount = 0;
    private static int techCount = 0;

    public static int getCount() {
        return count;
    }

    public static void increment() {
        count++;
    }

    public static void reset() {
        count = 0;
        mitCount = 0;
        natCount = 0;
        foodCount = 0;
        tripCount = 0;
        techCount = 0;
    }
    public static int getMitCount() {
        return mitCount;
    }

    public static int getNatCount() {
        return natCount;
    }

    public static int getFoodCount() {
        return foodCount;
    }

    public static int getTripCount() {
        return tripCount;
    }

    public static int getTechCount() {
        return techCount;
    }
    public static void incrementMitCount() {
        mitCount++;
    }

    public static void incrementNatCount() {
        natCount++;
    }

    public static void incrementFoodCount() {
        foodCount++;
    }

    public static void incrementTechCount() {
        techCount++;
    }

    public static void incrementTripCount() {
        tripCount++;
    }


}
