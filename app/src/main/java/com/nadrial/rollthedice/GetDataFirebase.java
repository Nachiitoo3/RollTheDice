package com.nadrial.rollthedice;

import java.util.ArrayList;
import java.util.List;

public class GetDataFirebase {
    private static List<ItemAchievement> itemAchievements;

    public static List<ItemAchievement> getItemsAchievements() {
        return itemAchievements;
    }

    public static void setItemsAchievements(List<ItemAchievement> itemsList) {
        itemAchievements = itemsList;
    }



    private static List<ItemStat> itemsStats;

    public static List<ItemStat> getItemsStats() {
        return itemsStats;
    }

    public static void setItemsStats(List<ItemStat> itemsList) {
        itemsStats = itemsList;
    }

    public static List<ItemStat> generateItemsStats() {

        List<ItemStat> items = new ArrayList<>();

        items.add(new ItemStat("Preguntas acertadas", "17"));


        return items;
    }
}
